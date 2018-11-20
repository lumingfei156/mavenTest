package com.maven.javaBean;

public class Person {
    private String name;
    private Integer age;

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void finalize() throws Throwable {

        System.out.println("黄锐建我敲尼玛！");
    }
}
