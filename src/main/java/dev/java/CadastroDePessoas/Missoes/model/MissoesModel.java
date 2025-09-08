package dev.java.CadastroDePessoas.Missoes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.java.CadastroDePessoas.Pessoas.model.PessoaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    // Uma missão pode ir para muitas pessoas
    @OneToMany(mappedBy = "missao")
    @JsonManagedReference
    private List<PessoaModel> pessoas;

    public MissoesModel() {}

    public MissoesModel(String nome, String dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<PessoaModel> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaModel> pessoas) {
        this.pessoas = pessoas;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
