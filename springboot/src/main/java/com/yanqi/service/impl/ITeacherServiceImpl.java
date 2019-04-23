package com.yanqi.service.impl;

import com.yanqi.dao.TeacherDaoImpl;
import com.yanqi.entity.Teacher;
import com.yanqi.service.ITeacherService;

public class ITeacherServiceImpl implements ITeacherService {
    TeacherDaoImpl teacherDao;
    @Override
    public void addTeacher(Teacher teacher) {

        teacherDao.addTeacher(teacher);
    }

    public TeacherDaoImpl getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(TeacherDaoImpl teacherDao) {
        this.teacherDao = teacherDao;
    }
}
