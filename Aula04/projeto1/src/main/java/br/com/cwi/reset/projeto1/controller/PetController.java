package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Filme;
import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.FilmeJaExistenteException;
import br.com.cwi.reset.projeto1.exception.FilmeNaoExistenteException;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.service.FilmeService;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService petService = new PetService();

    @GetMapping
    public List<Pet> consultarTodos() {
        return petService.listarTodos();
    }



    @GetMapping("/{nome}")
    public Pet buscarPetPeloNome(@PathVariable String nome) {
        return petService.buscarPorNome(nome);
    }

    @PostMapping
    public ResponseEntity<Pet> cadastrarPet(@RequestBody Pet pet) {
        try {
            Pet petSalvo = petService.salvar(pet);
            return ResponseEntity.ok(petSalvo);
        } catch (PetJaExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Pet> atualizarPet(@RequestBody Pet pet) {
        try {
            return ResponseEntity.ok(petService.atualizar(pet));
        } catch (PetNaoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity deletarPet(@PathVariable String nome) {
        try {
            petService.deletar(nome);
            return ResponseEntity.ok().build();
        } catch (PetNaoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
