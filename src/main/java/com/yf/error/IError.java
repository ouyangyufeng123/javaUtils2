package com.yf.error;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/16
 */
public interface IError {

    /**
     * 获取错误码
     * @return
     */
    String getErrorCode();

    /**
     * 获取错误信息
     * @return
     */
    String getErrorMessage();

}
