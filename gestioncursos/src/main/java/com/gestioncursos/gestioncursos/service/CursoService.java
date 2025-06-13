package com.gestioncursos.gestioncursos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioncursos.gestioncursos.model.Curso;
import com.gestioncursos.gestioncursos.model.EstadoCurso;
import com.gestioncursos.gestioncursos.repository.CursoRepository;

@Service
public class CursoService {
    
    /*
        Curso crearCurso(String nombreCurso, String descripcionCurso)
        Curso editarCurso(String idCurso, String nombreCurso, String descripcionCurso)
        void eliminarCurso(String idCurso)  
        List<Curso> encontrarCursos()
     */

    @Autowired
    private CursoRepository cursoRepository;

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso findxIdCurso(int idCurso) {
        return cursoRepository.findById(idCurso);
    }

    public List<Curso> findAllCursos() {
        return cursoRepository.findAll();
    }

    public List<Curso> findCursosPorEstado(EstadoCurso estadoCurso) {
        return cursoRepository.findByEstadoCurso(estadoCurso);
    }

    public Curso editCurso(Integer idCurso, Curso curso) {
        Optional<Curso> cursoExistente = cursoRepository.findById(idCurso);
        if (cursoExistente != null) {
            Curso cursoActualizado = cursoExistente.get();
            cursoActualizado.setNombre(curso.getNombre());
            cursoActualizado.setDescripcion(curso.getDescripcion());
            cursoActualizado.setEstadoCurso(curso.getEstadoCurso());
            return cursoRepository.save(cursoActualizado);
        }
        return null;
    }

    public Curso editEstadoCurso(int idCurso, Curso curso) {
    Curso cursoExistente = cursoRepository.findById(idCurso);
    if (cursoExistente != null) {
        cursoExistente.setEstadoCurso(curso.getEstadoCurso());
        return cursoRepository.save(cursoExistente);
    }
    return null;
}

}
