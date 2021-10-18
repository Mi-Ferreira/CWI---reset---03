package br.com.cwi.reset.michele.controller;


import br.com.cwi.reset.michele.request.AtorRequest;
import br.com.cwi.reset.michele.service.AtorService;
import br.com.cwi.reset.michele.validator.FakeDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {

        this.atorService = new AtorService(FakeDatabase.getInstance());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping(/{em_atividade})
    @ResponseStatus(HttpStatus.CREATED)
    public listarAtoresEmAtividade() throws Exception {
        return List <atorService.listarAtoresEmAtividade()>;
    }

    @GetMapping(/{id})
    @ResponseStatus(HttpStatus.CREATED)
    public consultarAtor(@PathVariable Integer id) throws Exception {
        return atorService.consultarAtor(Integer id)>;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public consultarAtores() {
        return List < Ator > atorService.consultarAtores();
    }
}