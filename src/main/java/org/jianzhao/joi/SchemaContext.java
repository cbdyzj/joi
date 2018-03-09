package org.jianzhao.joi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class SchemaContext<T> {

    private String message;

    private List<Schema<T>> schemas = new ArrayList<>();

    private boolean required = false;

    public Optional<String> validate(T target) {
        // target is null
        if (Objects.isNull(target)) {
            if (this.required) {
                return Optional.of(Objects.isNull(this.message) ? "Target required!" : this.message);
            } else {
                return Optional.empty();
            }
        }
        // target is not null
        return this.schemas.stream().map(schema -> schema.validate(target)).filter(Optional::isPresent).reduce(Optional.empty(), (a, c) -> c);

    }

    public void message(String message) {
        this.message = message;
    }

    public void required() {
        this.required = true;
    }

    public void addSchema(Schema<T> schema) {
        this.schemas.add(schema);
    }

    public void addPredicate(Predicate<T> predicate) {
        this.schemas.add(target -> predicate.test(target) ? Optional.empty() : Optional.of(Objects.isNull(this.message) ? "Validate failed!" : this.message));
    }
}
