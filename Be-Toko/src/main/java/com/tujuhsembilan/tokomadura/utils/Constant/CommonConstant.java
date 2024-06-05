package com.tujuhsembilan.tokomadura.utils.Constant;

public class CommonConstant {
    
    public static class ErrorCodeConstant {
        public static final String SUCCESS = "01";
        public static final String ERROR = "02";
    }

    public static class UsersConstant {
        public static final Integer ROLE_CUSTOMER = 2;
        public static final Integer ROLE_ADMIN = 1;
        public static final String ROLE_CUSTOMER_NAME = "CUSTOMER";
        public static final String ROLE_ADMIN_NAME = "ADMIN";

        public static String isRole(Integer role){
            if(role.equals(ROLE_ADMIN)){
                return ROLE_CUSTOMER_NAME;
            }else{
                return ROLE_ADMIN_NAME;
            }
        }
    }
}
