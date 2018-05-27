package org.jianzhao.joi.util;

import org.jianzhao.joi.Result;
import org.jianzhao.joi.Schema;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Schemas {

    private Schemas() {
    }

    public static <T> Schema<T> predicate(Predicate<T> predicate) {
        return target -> predicate.test(target) ? Result.valid() : Result.invalid();
    }

    public static Result merge(Result ra, Result rb) {
        if (ra.isValid() && rb.isValid()) {
            return Result.valid();
        }
        Set<String> messages = Stream.of(ra, rb)
                .filter(Result::isInvalid)
                .map(Result::getMessages)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        return Result.of(messages);
    }
}
