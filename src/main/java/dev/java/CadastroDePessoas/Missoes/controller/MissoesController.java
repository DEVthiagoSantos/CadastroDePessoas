package dev.java.CadastroDePessoas.Missoes.controller;

import dev.java.CadastroDePessoas.Missoes.model.MissoesModel;
import dev.java.CadastroDePessoas.Missoes.repository.MissoesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    public final MissoesRepository missoesRepository;

    public MissoesController(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Get - Listar Todos
    @GetMapping
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //Get {id} - busca por id
    @GetMapping("/{id}")
    public MissoesModel buscarMissaoPorId(@PathVariable Long id) {
        return missoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel achar essa missão"));
    }

    // Post - inserir/atualizar
    @PostMapping
    public MissoesModel adicionarMissoes(@RequestBody MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    // Put - atualizar missão existente
    @PutMapping("/{id}")
    public MissoesModel atualizarMissao(@PathVariable Long id, @RequestBody MissoesModel missoesModel) {
        MissoesModel existente = missoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Essa missão não existe"));

        existente.setNome(missoesModel.getNome());
        existente.setDificuldade(missoesModel.getDificuldade());
        return missoesRepository.save(existente);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void removerMissao(@PathVariable Long id) {
        if (!missoesRepository.existsById(id)) {
            throw new RuntimeException("Essa missão não existe");
        }
        missoesRepository.deleteById(id);
    }
}
