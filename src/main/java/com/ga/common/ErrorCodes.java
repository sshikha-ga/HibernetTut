package com.ga.common;

/**
 * The Enum ErrorCodes.
 * 
 * @author knilay
 */
public enum ErrorCodes {

    // Parameter format error
    GA_DATABASE_GENERAL(1001, "Database error"),
    GA_CONNECTION_DOWN(1002, "Database database down error"),
    GA_CONSTRAINT_VIOLATION_Action(1003, " CONSTRAINT Exception"),
    GA_SERVICE_DOWN(2001, "Service down. Please contact administrator."),
    GA_INTERNAL(2002, "Internal error occure. Please contact administrator."),
    GA_AUTH_FAILED(4265, "Authentication failed"),
    GA_PARAMETERS_WRONG(4266, "Wrong parameters given. Please try again"),
    GA_MAXIMUM_ATTEMPT_REACHED(4268, "Maximumm number of attempt reached"),
    GA_MANDATORY_PARAMETERS_NOT_SET(4289, "Mandatory Parameters missing"),
    GA_USER_LOCKED(4293, "User is locked"),
    GA_DATA_NOT_FOUND(4294, "Requested data not found"),
    GA_ISSUER_TIMEOUT(4295, "Service did not respond in time"),
    GA_SIZE_EXCEED(4200, "Size Exceed"),
    GA_ACTION_UNSUPPORTED(4201, "Action Unsupported"),
    GA_File_Upload(4500, "File Upload Exception"),
    GA_SECURITY_POLICY_VIOLATION(1005, "Security Violation.");

    int errorCode;
    String description;

    /**
     * Instantiates a new error codes.
     * 
     * @param errorCode the error code
     * @param description the description
     */
    private ErrorCodes(int errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    /**
     * Gets the error code.
     * 
     * @return the error code
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     * 
     * @param errorCode the new error code
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * 
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}