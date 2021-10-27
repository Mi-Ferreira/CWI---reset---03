package br.com.cwi.reset.michele.controller;


import br.com.cwi.reset.michele.request.DiretorRequest;
import br.com.cwi.reset.michele.service.DiretorService;
import br.com.cwi.reset.michele.validator.FakeDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {

        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }


    @GetMapping(path = "/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
        return this.diretorService.consultarDiretor(id);
    }

    @GetMapping
    public List<Diretor> consultarDiretores(@RequestParam String filtroNome) throws Exception{
        return this.diretorService.consultarDiretores(filtroNome);
    }

}
