package org.jianzhao.joi;

import java.util.Optional;

public interface Schema<T> {

    Optional<String> validate(T target);
}
