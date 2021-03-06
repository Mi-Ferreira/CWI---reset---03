package br.com.cwi.reset.michele.controller;

import br.com.cwi.reset.michele.request.FilmeRequest;
import br.com.cwi.reset.michele.service.FilmeService;
import br.com.cwi.reset.michele.validator.FakeDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class FilmeController {
    private FilmeService filmeService;

    public FilmeController() {
        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception {
        filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    public List<Filme> consultarFilmes(
            @RequestParam String nomeFilme,
            @RequestParam String nomeDiretor,
            @RequestParam String nomePersonagem,
            @RequestParam String nomeAtor) throws Exception {
        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }


}
