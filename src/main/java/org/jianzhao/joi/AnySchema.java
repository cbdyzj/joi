package org.jianzhao.joi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public abstract class AnySchema<T, S extends AnySchema<T, ?>> implements Schema<T> {

    private static final Result DEFAULT_RESULT = Result.of("Validate failed!");

    private Result result = Result.valid();
    private List<Schema<T>> schemas = new ArrayList<>();
    private boolean required = false;

    @Override
    public Result validate(T target) {
        // target is null
        if (Objects.isNull(target)) {
            return this.validateNull();
        }
        // target is not null
        Optional<Result> anyResult = this.schemas.stream()
                .map(schema -> schema.validate(target))
                .filter(Result::nonValid)
                .findAny();
        if (!anyResult.isPresent()) {
            return Result.valid();
        }
        if (this.result.nonValid()) {
            return this.result;
        }
        return anyResult.get();
    }

    public S message(String message) {
        this.result = Result.of(message);
        return (S) this;
    }

    public S required() {
        this.required = true;
        return (S) this;
    }

    public S schema(Schema<T> schema) {
        this.schemas.add(schema);
        return (S) this;
    }

    public S predicate(Predicate<T> predicate) {
        this.schemas.add(target -> predicate.test(target) ? Result.valid() : DEFAULT_RESULT);
        return (S) this;
    }

    private Result validateNull() {
        if (this.required) {
            if (this.result.nonValid()) {
                return this.result;
            } else {
                return DEFAULT_RESULT;
            }
        } else {
            return Result.valid();
        }
    }
}
