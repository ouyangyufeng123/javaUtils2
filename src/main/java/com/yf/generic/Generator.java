package com.yf.generic;

/**
 * Created by ouyangyufeng on 2019/5/13.
 */
public interface Generator<T> {
    public T next(T t);

    public <T extends String> T next2(T t);
}
