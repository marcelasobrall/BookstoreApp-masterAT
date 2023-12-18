package br.edu.infnet.BookstoreApp.repositories;

import br.edu.infnet.BookstoreApp.model.domain.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro,Integer> {
    Livro findByTitulo(String titulo);
    Livro findByTituloIgnoreCase(String titulo);
}
