package com.example.reto.repository;

import com.example.reto.mapper.MyBatisCursoMapper;
import com.example.reto.model.Curso;
import com.example.reto.model.CursoBuilder;
import com.example.reto.model.Profesor;
import com.example.reto.ports.CursoRepository;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository(value = "MyBatisCursoRepository")
public class MyBatisCursoRepository implements CursoRepository {

    private final MyBatisCursoMapper cursoAccess;

    @Autowired
    public MyBatisCursoRepository(MyBatisCursoMapper cursoAccess) {
        super();
        this.cursoAccess = cursoAccess;
    }

    @Override
    public void addCurso(Curso curso) {
        cursoAccess.addCurso(curso);
    }

    @Override
    public List<Curso> selectCursos(int page, int rows) {
        List<Map<String, Object>> results = cursoAccess.selectCursosMap(new RowBounds(page*rows, rows));
        return results
                .stream()
                .map(curso -> new CursoBuilder()
                        .id((int) curso.get("ID"))
                        .active((boolean) curso.get("ACTIVO"))
                        .title((String) curso.get("TITULO"))
                        .teacher(new Profesor((int) curso.get("ID_PROFESOR"), (String) curso.get("NOMBRE")))
                        .level((String) curso.get("NIVEL"))
                        .hours((int) curso.get("HORAS"))
                        .syllabusUrl((String) curso.get("TEMARIOURL"))
                        .build())
                .collect(Collectors.toList());
        //return cursoAccess.selectCursos(new RowBounds(page*rows, rows));
    }

    @Override
    public int selectCursosCount() {
        return cursoAccess.selectCursosCount();

    }

}