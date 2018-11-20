package com.maven.test1;

public class AssertTest {

    String name;
    String age;

    public AssertTest(String name){
        this.name = name;
    }

    public AssertTest(){

    }

    public static void main(String[] args) {

//        AssertTest a = new AssertTest("小虎");
        AssertTest a = new AssertTest();
        String persoName = null;
        assert (persoName = a.getName() ) != null:"敲你妈";
        System.out.println(persoName.length());


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
