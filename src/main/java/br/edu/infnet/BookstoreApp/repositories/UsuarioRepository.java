package br.edu.infnet.BookstoreApp.repositories;

import br.edu.infnet.BookstoreApp.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
    Usuario findByEmail(String email);
}
