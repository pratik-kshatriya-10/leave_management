package com.pheonix.leavemanagement.utils;

public class Constants {

    private Constants(){
        //No Use
    }

    public static final String BASE_URL = "/api/v1";
    public static final String DEPARTMENT_ID = "departmentId";
    public static final String DESIGNATION_ID = "designationId";
    public static final int DEFAULT_LIMIT = 20;

    public static class RegexPattern{
        private RegexPattern(){
            // No Use
        }
        public static final String ALPHABETICAL_CHARACTERS = "^[A-Za-z ]+$";
        public static final String SMALL_LETTERS_WITH_NUMBERS = "^[a-z0-9]+$";
        public static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        public static final String NUMBER_PATTERN = "^[0-9]+$";

    }
}
