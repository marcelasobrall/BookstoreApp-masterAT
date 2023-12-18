package br.edu.infnet.BookstoreApp.repositories;

import br.edu.infnet.BookstoreApp.model.domain.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido,Integer> {

}
