package org.jianzhao.joi;

public interface Schema<T> {

    boolean validate(T target);
}
