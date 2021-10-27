package br.com.cwi.reset.michele.controller;

import br.com.cwi.reset.michele.request.EstudioRequest;
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
    public List <Estudio> consultarEstudios(@RequestParam String filtroNome) throws Exception {
        return estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping(path="/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {
        return estudioService.consultarEstudio(id);
    }
}


