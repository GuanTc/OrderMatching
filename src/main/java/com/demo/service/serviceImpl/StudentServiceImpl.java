package com.demo.service.serviceImpl;

import com.demo.mapper.EntitycourseMapper;
import com.demo.pojo.Entitycourse;
import com.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private EntitycourseMapper entitycourseMapper;
    @Override
    public List<Entitycourse> findAll() {
        return entitycourseMapper.findAll();
    }
}
