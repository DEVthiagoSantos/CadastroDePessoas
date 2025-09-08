package dev.java.CadastroDePessoas.Pessoas.service;

import dev.java.CadastroDePessoas.Missoes.model.MissoesModel;
import dev.java.CadastroDePessoas.Missoes.repository.MissoesRepository;
import dev.java.CadastroDePessoas.Pessoas.model.PessoaModel;
import dev.java.CadastroDePessoas.Pessoas.repository.PessoasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    public final PessoasRepository pessoasRepository;
    public final MissoesRepository missoesRepository;

    public PessoaService(PessoasRepository pessoasRepository, MissoesRepository missoesRepository) {
        this.pessoasRepository = pessoasRepository;
        this.missoesRepository = missoesRepository;
    }

    //Post
    public PessoaModel adicionarPessoa(PessoaModel pessoa) {
        return pessoasRepository.save(pessoa);
    }

    // Get
    public List<PessoaModel> listarPessoas() {
        return pessoasRepository.findAll();
    }

    // Get (id)
    public PessoaModel mostrarPessoa(Long id) {
        return pessoasRepository.findById(id).orElse(null);
    }

    // Put
    public PessoaModel atribuirMissao(Long idPessoa, Long idMissao) {
        PessoaModel pessoa = pessoasRepository.findById(idPessoa)
                .orElseThrow(() -> new RuntimeException("Essa pessoa não foi encontrada"));
        MissoesModel missao = missoesRepository.findById(idMissao)
                .orElseThrow(() -> new RuntimeException("Essa missão não foi encontrada"));

        pessoa.setMissao(missao);
        return pessoasRepository.save(pessoa);
    }

    // Delete
    public void removerPessoa(Long idPessoa) {
        if (!pessoasRepository.existsById(idPessoa)) {
            throw new RuntimeException("Essa pessoa não foi encontrada (talvez você já tenha removido)");
        }
        pessoasRepository.deleteById(idPessoa);
    }
}
