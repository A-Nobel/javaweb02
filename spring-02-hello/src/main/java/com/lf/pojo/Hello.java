package com.lf.pojo;

public class Hello {
    private String str;

    public Hello() {
    }

    public Hello(String str) {
        this.str = str;
    }

    /**
     * 获取
     * @return str
     */
    public String getStr() {
        return str;
    }

    /**
     * 设置
     * @param str
     */
    public void setStr(String str) {
        this.str = str;
    }

    public String toString() {
        return "Hello{str = " + str + "}";
    }
}
