package br.com.caelum.application.controllers;

import br.com.caelum.domain.models.StockItem;
import br.com.caelum.domain.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockItemController {

    @Value("${server.port}")
    private Long port;

    private final StockRepository repository;

    public StockItemController(StockRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockItem> getById(@PathVariable("code") String code){
        System.out.println();
        System.out.println(code);
        System.out.println(port);
        System.out.println();
        return repository.findByCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.noContent()::build);
    }

}
