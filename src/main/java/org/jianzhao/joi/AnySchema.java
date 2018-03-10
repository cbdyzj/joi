package org.jianzhao.joi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public abstract class AnySchema<T, S extends AnySchema<T, ?>> implements Schema<T> {

    private static final String DEFAULT_MESSAGE = "Validate failed!";
    private String message = DEFAULT_MESSAGE;
    private List<Schema<T>> schemas = new ArrayList<>();
    private boolean required = false;

    @Override
    public Optional<String> validate(T target) {
        // target is null
        if (Objects.isNull(target)) {
            if (this.required) {
                return Optional.of(this.message);
            } else {
                return Optional.empty();
            }
        }
        // target is not null
        Optional<String> message = this.schemas.stream().map(schema -> schema.validate(target)).filter(Optional::isPresent).reduce(Optional.empty(), (a, c) -> c);
        if (message.isPresent() && !this.message.equals(DEFAULT_MESSAGE)) {
            message = Optional.of(this.message);
        }
        return message;
    }

    public S message(String message) {
        this.message = message;
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
        this.schemas.add(target -> predicate.test(target) ? Optional.empty() : Optional.of(this.message));
        return (S) this;
    }
}
