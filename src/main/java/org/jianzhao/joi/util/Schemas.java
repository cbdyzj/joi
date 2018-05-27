package org.jianzhao.joi.util;

import org.jianzhao.joi.Result;
import org.jianzhao.joi.Schema;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
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
        long c = Stream.of(ra, rb)
                .filter(Result::isInvalid)
                .count();
        if (c == 0) {
            return Result.valid();
        }
        Set<String> messages = Stream.of(ra, rb)
                .filter(Result::isInvalid)
                .map(Result::getMessages)
                .map(Collection::stream)
                .flatMap(Function.identity())
                .collect(Collectors.toSet());
        return Result.of(messages);
    }
}
