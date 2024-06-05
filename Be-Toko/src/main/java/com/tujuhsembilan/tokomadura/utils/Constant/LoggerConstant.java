package com.tujuhsembilan.tokomadura.utils.Constant;

public class LoggerConstant {
    
    public static class ErrorCommonResponse {
        public static final String EMAIL_EXIST = "Maaf Email sudah digunakan.";
        public static final String UNKNOWN_ERROR = "Error tidak diketahui.";
        public static final String REPASSWORD_NOT_VALID = "Re Password tidak sama dengan password.";

        public static final String EMAIL_OR_PASSWORD_INVALID = "Email atau password tidak valid.";
    }

    public static class SuccessCommonResponse {
        public static final String SUCCESS_SAVE = "Berhasil menyimpan data.";
        public static final String SUCCESS_LOGIN = "Berhasil Login.";
    }
}
