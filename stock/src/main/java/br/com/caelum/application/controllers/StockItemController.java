package br.com.caelum.application.controllers;

import br.com.caelum.domain.models.StockItem;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StockItemController {


    @GetMapping(value = "{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<StockItem> getById(@PathVariable("code") String code){
        return Optional.empty();
    }

}
