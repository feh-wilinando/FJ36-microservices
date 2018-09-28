package br.com.caelum.application.controllers;

import br.com.caelum.domain.models.StockItem;
import br.com.caelum.domain.repositories.StockRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockItemController {

    private final StockRepository repository;

    public StockItemController(StockRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockItem> getById(@PathVariable("code") String code){
        return repository.findByCode(code).map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }

}
