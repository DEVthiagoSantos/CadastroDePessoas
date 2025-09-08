package dev.java.CadastroDePessoas.Pessoas.model;

import dev.java.CadastroDePessoas.Missoes.model.MissoesModel;
import jakarta.persistence.*;

// Entity transforma uma classe me uma entidade do banco de dados
// Uma entidade que vai persistir no banco de dados
@Entity
@Table(name = "tb_cadastro")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // Uma pessoa tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "missao_id") //Foreing Key, chave estrangeira
    private MissoesModel missao;

    public PessoaModel() {} //NoAllConstructor

    public PessoaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    } // AllConstructor

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MissoesModel getMissao() {
        return missao;
    }

    public void setMissao(MissoesModel missoes) {
        this.missao = missoes;
    }
}
