package com.lf.pojo;

public class User {
    private String name;

    public User() {
        System.out.println("User create");
    }

    public User(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name="+name);
    }

    public String toString() {
        return "User{name = " + name + "}";
    }
}
