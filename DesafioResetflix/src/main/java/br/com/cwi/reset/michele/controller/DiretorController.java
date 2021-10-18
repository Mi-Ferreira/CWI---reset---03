package br.com.cwi.reset.michele.controller;


import br.com.cwi.reset.michele.request.DiretorRequest;
import br.com.cwi.reset.michele.service.DiretorService;
import br.com.cwi.reset.michele.validator.FakeDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(/{id})
    @ResponseStatus(HttpStatus.CREATED)
    public consultarDiretores(@PathVariable Integer id) throws Exception {
        return diretorService.consultarDiretores(Integer id)>;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public consultarDiretores() {
        return diretorService.consultarDiretores();
    }

}
