package dev.java.CadastroDePessoas.Pessoas.controller;
import dev.java.CadastroDePessoas.Pessoas.model.PessoaModel;
import dev.java.CadastroDePessoas.Pessoas.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cdr-pessoas")
public class PessoaController {

    public final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // GET - Listar Pessoas
    @GetMapping
    public List<PessoaModel> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}/buscar")
    public PessoaModel buscarPessoaPorId(@PathVariable Long id) {
        return pessoaService.mostrarPessoa(id);
    }

    @PostMapping
    public PessoaModel adicionarPessoa(@RequestBody PessoaModel pessoa) {
        return pessoaService.adicionarPessoa(pessoa);
    }

    @PutMapping("/{idPessoa}/missao/{idMissao}")
    public PessoaModel atribuirMissao(@PathVariable Long idPessoa, @PathVariable Long idMissao) {
        return pessoaService.atribuirMissao(idPessoa, idMissao);
    }

    // Delete {id}
    @DeleteMapping("/delete/{id}")
    public void removerPessoa(@PathVariable Long id) {
        pessoaService.removerPessoa(id);
    }

}