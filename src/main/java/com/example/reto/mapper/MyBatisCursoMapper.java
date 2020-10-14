package com.example.reto.mapper;


import com.example.reto.model.Curso;
import com.example.reto.model.Profesor;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyBatisCursoMapper {
    @Insert("INSERT INTO curso (activo,titulo,id_profesor,nivel,horas,temarioUrl) VALUES (#{activo},#{titulo},#{profesor.id},#{nivel},#{horas},#{temarioUrl})")
    void addCurso(Curso curso);

    @Select("SELECT * FROM curso WHERE activo=true ORDER BY titulo ASC")
    @ConstructorArgs({
            @Arg(column = "id", javaType = int.class),
            @Arg(column = "activo", javaType = boolean.class),
            @Arg(column = "titulo", javaType = String.class),
            @Arg(column = "id_profesor", select = "com.example.reto.mapper.MyBatisProfesorMapper.selectProfesorById", javaType = Profesor.class, id = true),
            @Arg(column = "nivel", javaType = String.class),
            @Arg(column = "horas", javaType = int.class),
            @Arg(column = "temarioUrl", javaType = String.class)
    })
    List<Curso> selectCursos(RowBounds rb);

    @Select("SELECT * FROM curso INNER JOIN profesor ON curso.id_profesor = profesor.id WHERE activo=true ORDER BY titulo ASC")
    List<Map<String, Object>> selectCursosMap(RowBounds rb);

    @Select("SELECT COUNT(id) FROM curso WHERE activo=true")
    int selectCursosCount();
}
