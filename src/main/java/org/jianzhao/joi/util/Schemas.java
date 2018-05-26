package org.jianzhao.joi.util;

import org.jianzhao.joi.Result;
import org.jianzhao.joi.Schema;

import java.util.function.Predicate;

public final class Schemas {

    private Schemas() {
    }

    public static <T> Schema<T> predicate(Predicate<T> predicate) {
        return target -> predicate.test(target) ? Result.valid() : Result.invalid();
    }
}
