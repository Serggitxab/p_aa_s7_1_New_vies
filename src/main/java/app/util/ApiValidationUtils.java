package app.util;

import app.exceptions.ApiValidationException;

public class ApiValidationUtils {

    public static void expectedTrue(boolean val, int code, String message) {
        if (!val) {
            throw new ApiValidationException(code, message);
        }
    }

    public static void expectedFalse(boolean val, int code, String message) {
        if (val) {
            throw new ApiValidationException(code, message);
        }
    }

}

