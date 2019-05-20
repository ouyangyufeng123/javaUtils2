package com.yf.generic;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by ouyangyufeng on 2019/5/13.
 */
class FruitGenerator<T> implements Generator<T>{

    @Override
    public T next(T t) {
        System.out.println(t.getClass());
        return null;
    }

    @Override
    public <T1 extends String> T1 next2(T1 t1) {
        return null;
    }

}
