package com.demo.mapper;

import com.demo.pojo.Entitycourse;
import com.demo.pojo.EntitycourseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EntitycourseMapper {
    int countByExample(EntitycourseExample example);

    int deleteByExample(EntitycourseExample example);

    int deleteByPrimaryKey(Long entitycourseId);

    int insert(Entitycourse record);

    int insertSelective(Entitycourse record);

    List<Entitycourse> selectByExampleWithBLOBs(EntitycourseExample example);

    List<Entitycourse> selectByExample(EntitycourseExample example);

    Entitycourse selectByPrimaryKey(Long entitycourseId);

    int updateByExampleSelective(@Param("record") Entitycourse record, @Param("example") EntitycourseExample example);

    int updateByExampleWithBLOBs(@Param("record") Entitycourse record, @Param("example") EntitycourseExample example);

    int updateByExample(@Param("record") Entitycourse record, @Param("example") EntitycourseExample example);

    int updateByPrimaryKeySelective(Entitycourse record);

    int updateByPrimaryKeyWithBLOBs(Entitycourse record);

    int updateByPrimaryKey(Entitycourse record);

    List<Entitycourse> findAll();
}