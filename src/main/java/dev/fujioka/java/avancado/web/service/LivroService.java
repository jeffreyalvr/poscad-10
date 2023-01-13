package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.model.Livro;
import dev.fujioka.java.avancado.web.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro adicionar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro consultarPorId(int id) {
        return livroRepository.findById(id).orElseThrow();
    }

    public void excluir(int id) {
        livroRepository.deleteById(id);
    }

    public Livro alterar(Livro livro) {
        if (Objects.isNull(livro.getId())) {
            throw new RuntimeException("id não preenchido");
        }
        return livroRepository.save(livro);
    }

}
