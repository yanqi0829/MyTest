package com.yanqi.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Course {
    private  String courseName;
    private  int cTime;
    private  Teacher teacher; //授课老师依赖于 Teacher类

    public Course() {
    }

    public Course(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getcTime() {
        return cTime;
    }

    public void setcTime(int cTime) {
        this.cTime = cTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", cTime=" + cTime +
                ", teacher=" + teacher +
                '}';
    }

    public static void main(String[] args) {
        //容器对象
        ApplicationContext context= new ClassPathXmlApplicationContext("contxet.xml");
        Course course= (Course) context.getBean("course");
        System.out.println(course);


//自动装配
        Course course1= (Course) context.getBean("course1");
        System.out.println(course1);
    }
}
