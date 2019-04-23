package com.yanqi.entity;

import com.yanqi.service.ITeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Student {
    private String stName;
    private  String stAge;

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStAge() {
        return stAge;
    }

    public void setStAge(String stAge) {
        this.stAge = stAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stName='" + stName + '\'' +
                ", stAge='" + stAge + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("contxet.xml");
        Student stu= (Student) context.getBean("stu");
        System.out.println(stu);

        ApplicationContext context1= new ClassPathXmlApplicationContext("contxet.xml");
        ITeacherService iTeacherService= (ITeacherService) context1.getBean("iTeacherService");
       Teacher ta= new Teacher();
        iTeacherService.addTeacher(ta);
    }
}
