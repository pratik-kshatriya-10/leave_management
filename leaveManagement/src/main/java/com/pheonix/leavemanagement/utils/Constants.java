package com.pheonix.leavemanagement.utils;

import java.util.List;

public class Constants {

    private Constants(){
        //No Use
    }

    public static final String BASE_URL = "/api/v1";
    public static final String DEPARTMENT_ID = "departmentId";
    public static final String DESIGNATION_ID = "designationId";
    public static final String USER_ID = "userId";
    public static final String LEAVE_ID = "leaveId";
    public static final int DEFAULT_LIMIT = 20;
    public static final String SUCCESS = "Success";
    public static final String ERROR = "error";

    public static class RegexPattern{
        private RegexPattern(){
            // No Use
        }
        public static final String ALPHABETICAL_CHARACTERS = "^[A-Za-z ]+$";
        public static final String SMALL_LETTERS_WITH_NUMBERS = "^[a-z0-9]+$";
        public static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        public static final String NUMBER_PATTERN = "^[0-9]+$";

    }
    public static class LeaveStatuses{
        private LeaveStatuses(){
            // No Use
        }
        public static final String PENDING = "Pending";
        public static final String APPROVED = "Approved";
        public static final String CANCELLED = "Cancelled";

        public static final List<String> leaveStatuses = List.of(PENDING, APPROVED ,CANCELLED);
    }
}
