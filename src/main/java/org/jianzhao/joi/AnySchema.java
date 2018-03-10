package org.jianzhao.joi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public abstract class AnySchema<T, S extends AnySchema<T, ?>> implements Schema<T> {

    private static final String DEFAULT_MESSAGE = "Validate failed!";

    private Supplier<Optional<String>> message = () -> Optional.of(DEFAULT_MESSAGE);
    private Supplier<Optional<String>> requiredMessage = Optional::empty;

    private List<Schema<T>> schemas = new ArrayList<>();

    @Override
    public Optional<String> validate(T target) {
        // target is null
        if (Objects.isNull(target)) {
            return this.requiredMessage.get();
        }
        // target is not null
        Optional<String> message = this.schemas.stream().map(schema -> schema.validate(target)).filter(Optional::isPresent).reduce(Optional.empty(), (a, c) -> c);
        if (message.isPresent() && this.message.get().isPresent() && !DEFAULT_MESSAGE.equals(this.message.get().get())) {
            message = this.message.get();
        }
        return message;
    }

    public S message(String message) {
        this.message = () -> Optional.of(message);
        return (S) this;
    }

    public S required() {
        this.requiredMessage = () -> Optional.of(DEFAULT_MESSAGE);
        return (S) this;
    }

    public S schema(Schema<T> schema) {
        this.schemas.add(schema);
        return (S) this;
    }

    public S predicate(Predicate<T> predicate) {
        this.schemas.add(target -> predicate.test(target) ? Optional.empty() : this.message.get());
        return (S) this;
    }
}
