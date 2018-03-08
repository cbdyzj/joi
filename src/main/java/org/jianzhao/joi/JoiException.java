package org.jianzhao.joi;

@SuppressWarnings("WeakerAccess")
public class JoiException extends RuntimeException {

    public JoiException(String message) {
        super(message);
    }

    public JoiException(String message, Throwable cause) {
        super(message, cause);
    }
}
