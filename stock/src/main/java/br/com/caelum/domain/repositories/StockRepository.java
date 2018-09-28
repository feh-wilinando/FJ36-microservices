package br.com.caelum.domain.repositories;

import br.com.caelum.domain.models.StockItem;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface StockRepository extends Repository<StockItem, Long> {

    Optional<StockItem> findByCode(String code);

}
