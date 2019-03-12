package com.cnpm.letcook.Model;

public class User {
    String name;
    int age;

    public User() {
        this.age = 0;
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfoUser() {
        return name + " " + age;
    }
}
