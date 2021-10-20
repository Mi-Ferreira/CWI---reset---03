package br.com.cwi.reset.michele.controller;

import br.com.cwi.reset.michele.model.Estudio;
import br.com.cwi.reset.michele.request.DiretorRequest;
import br.com.cwi.reset.michele.request.EstudioRequest;
import br.com.cwi.reset.michele.service.DiretorService;
import br.com.cwi.reset.michele.service.EstudioService;
import br.com.cwi.reset.michele.validator.FakeDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    private EstudioService estudioService;

    public EstudioController() {

        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    public List <Estudio> consultarEstudios(String filtroNome) throws Exception {
        return estudioService.consultarEstudios();
    }

    @GetMapping("/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {
        return estudioService.consultarEstudio(Integer id);
    }
}


