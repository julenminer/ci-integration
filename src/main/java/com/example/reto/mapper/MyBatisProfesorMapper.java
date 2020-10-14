package com.example.reto.mapper;

import com.example.reto.model.Profesor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyBatisProfesorMapper {
    @Select("SELECT * FROM profesor")
    List<Profesor> selectProfesores();

    @Select("SELECT * FROM profesor WHERE id=#{id}")
    Profesor selectProfesorById(int id);
}