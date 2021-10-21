package br.com.cwi.reset.michele.controller;

import br.com.cwi.reset.michele.service.EstudioService;
import br.com.cwi.reset.michele.service.FilmeService;
import br.com.cwi.reset.michele.validator.FakeDatabase;

public class FilmeController {
    private FilmeService filmeService;

    public FilmeController() {

        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }


}
