package org.jianzhao.joi;

public interface Schema<T> {

    Result validate(T target);
}
