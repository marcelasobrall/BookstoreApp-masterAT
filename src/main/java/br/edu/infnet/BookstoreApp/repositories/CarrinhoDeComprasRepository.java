package br.edu.infnet.BookstoreApp.repositories;

import br.edu.infnet.BookstoreApp.model.domain.CarrinhoDeCompras;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoDeComprasRepository extends CrudRepository<CarrinhoDeCompras,Integer> {

}
