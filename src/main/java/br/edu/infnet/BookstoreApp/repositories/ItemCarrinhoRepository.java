package br.edu.infnet.BookstoreApp.repositories;

import br.edu.infnet.BookstoreApp.model.domain.ItemDeCarrinho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCarrinhoRepository extends CrudRepository<ItemDeCarrinho,Integer> {

}
