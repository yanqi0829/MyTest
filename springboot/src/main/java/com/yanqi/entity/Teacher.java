package com.yanqi.entity;

import com.yanqi.dao.TeacherDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class Teacher {

    private String name;
    private int age;
    @Autowired
    private TeacherDaoImpl teacherDao;
    public Teacher() {
    }
    public Teacher(String name, int age) {
        System.out.println("Constructor ...赋值");
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
