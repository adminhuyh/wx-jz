package com.tencent.wxcloudrun.constant;

public enum Sex {
    NOKNOW(0,"未知"),
    MAN(1,"男"),
    WOMAN(2,"女");

    private final int code;
    private final String name;


    private Sex(int code, String name) {
        this.code = code;
        this.name = name;

    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }


}
