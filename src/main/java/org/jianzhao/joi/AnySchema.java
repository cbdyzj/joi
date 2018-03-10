package org.jianzhao.joi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public abstract class AnySchema<T, S extends AnySchema<T, ?>> implements Schema<T> {

    private static final Supplier<Optional<String>> DEFAULT_MESSAGE = () -> Optional.of("Validate failed!");

    private Supplier<Optional<String>> message = Optional::empty;
    private List<Schema<T>> schemas = new ArrayList<>();
    private boolean required = false;

    @Override
    public Optional<String> validate(T target) {
        // target is null
        if (Objects.isNull(target)) {
            return this.validateNull();
        }
        // target is not null
        Optional<Optional<String>> anyMessage = this.schemas.stream()
                .map(schema -> schema.validate(target))
                .filter(Optional::isPresent)
                .findAny();
        if(!anyMessage.isPresent()){
            return Optional.empty();
        }
        if(this.message.get().isPresent()){
            return this.message.get();
        }
        return anyMessage.get();
    }

    public S message(String message) {
        this.message = () -> Optional.of(message);
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
        this.schemas.add(target -> predicate.test(target) ? Optional.empty() : DEFAULT_MESSAGE.get());
        return (S) this;
    }

    private Optional<String> validateNull(){
        if(this.required){
            if(this.message.get().isPresent()){
                return this.message.get();
            }else {
                return DEFAULT_MESSAGE.get();
            }
        }else {
            return Optional.empty();
        }
    }
}
