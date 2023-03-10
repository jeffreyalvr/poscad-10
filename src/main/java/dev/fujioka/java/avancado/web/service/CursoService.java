package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso adicionar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso consultarPorId(int id) {
        return cursoRepository.findById(id).orElseThrow();
    }

    public List<Curso> consultarPorArea(String area) {
        return cursoRepository.buscarCursoPorAreaLike(area);
    }

    public void excluir(int id) {
        cursoRepository.deleteById(id);
    }

    public Curso alterar(Curso curso) {
        if (Objects.isNull(curso.getId())) {
            throw new RuntimeException("id não preenchido");
        }
        return cursoRepository.save(curso);
    }

}
