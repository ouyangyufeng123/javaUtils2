package com.yf.game.model;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/17
 */
public enum Status {
    SCISSORS("剪刀"),
    STONE("石头"),
    CLOTH("布");

    /**
     * 属性
     */
    private String attribute;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    private Status(String attribute){
        this.attribute = attribute;
    }
}
