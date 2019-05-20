package com.yf.error;

import java.io.Serializable;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/16
 */
public class BaseResponse implements Serializable{

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
    private BaseResponse.Status status;

    public BaseResponse.Status getStatus() {
        return this.status;
    }

    public void setStatus(BaseResponse.Status status) {
        this.status = status;
    }

    public BaseResponse() {
        this.status = BaseResponse.Status.SUCCEED;
        this.errorCode = "200";
    }

    public BaseResponse(IError error) {
        this.status = BaseResponse.Status.SUCCEED;
        this.errorCode = error.getErrorCode();
        this.errorMessage = error.getErrorMessage();
        this.status = BaseResponse.Status.FAILED;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.errorCode != null) {
            sb.append("ErrorCode : ").append(this.errorCode).append("ErrorMessage : ").append(this.errorMessage);
        } else {
            sb.append("Succeed");
        }

        return sb.toString();
    }

    public static enum Status {
        SUCCEED,
        FAILED;

        private Status() {
        }
    }

}
