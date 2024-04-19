package br.hackathan.com.hackathan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hackathan.com.hackathan.model.Item;
import br.hackathan.com.hackathan.model.PontoAcesso;
import br.hackathan.com.hackathan.repository.ItemRepository;
import br.hackathan.com.hackathan.repository.PontoRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/main")
public class MainController {

    private final ItemRepository itemRepository;
    private final PontoRepository pontoRepository;

    public MainController(ItemRepository itemRepository, PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
        this.itemRepository = itemRepository;
    }
    
    @GetMapping("/itens")
    public List<Item> getMethodName() {
        List<Item> itens = itemRepository.findAll();
        System.out.println("Item example: "+itens.get(0));
        return itens;
    }

    @GetMapping("/pontos")
    public List<PontoAcesso> ponto() {
        return pontoRepository.findAll();
    }
}
