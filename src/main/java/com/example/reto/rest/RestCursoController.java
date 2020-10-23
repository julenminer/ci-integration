package com.example.reto.rest;

import com.example.reto.model.Curso;
import com.example.reto.model.CursoBuilder;
import com.example.reto.model.Profesor;
import com.example.reto.ports.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestCursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping(path = "/cursos")
    public Map<String, Object> getCursos(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows){
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("size", cursoRepository.selectCursosCount());
        responseMap.put("items", cursoRepository.selectCursos(page, rows));
        return responseMap;
    }

    @PostMapping(path = "/cursos")
    public void saveCurso(
            @RequestBody Map<String, Object> payload,
            HttpServletResponse response){
        try {
            boolean activo = payload.containsKey("activo") ? (boolean) payload.get("activo") : false;
            Curso curso = new CursoBuilder()
                    .active(activo)
                    .title((String) payload.get("titulo"))
                    .teacher(new Profesor(
                            (int) ((Map<String, Object>) payload.get("profesor")).get("id"),
                            (String) ((Map<String, Object>) payload.get("profesor")).get("nombre")))
                    .level((String) payload.get("nivel"))
                    .hours((int) payload.get("horas"))
                    .syllabusUrl((String) payload.get("temarioUrl"))
                    .build();
            cursoRepository.addCurso(curso);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
