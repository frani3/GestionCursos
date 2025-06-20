package com.gestioncursos.gestioncursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioncursos.gestioncursos.model.Curso;
import com.gestioncursos.gestioncursos.model.EstadoCurso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
   
    /*
        Curso crearCurso(String nombreCurso, String descripcionCurso)
        Curso editarCurso(String idCurso, String nombreCurso, String descripcionCurso)
        void eliminarCurso(String idCurso)  
        List<Curso> encontrarCursos()
     */

    
    Curso save(Curso curso);
    Curso findById(int idCurso);
    List<Curso> findAll();
    List<Curso> findByEstadoCurso(EstadoCurso estadoCurso);
    /// Curso deleteById(int idCurso); NO VA
    
    

    
}
