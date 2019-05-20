package com.yf.error;


/**
 *
 * @author ouyangyufeng
 * @date 2019/4/16
 */
public enum DefaultError implements IError{
    SYSTEM_INTERNAL_ERROR("0000", "系统错误");

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;


    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorCode;
    }


    private DefaultError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private DefaultError(String errorCode, String errorMessage, String extErrorMsg) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
