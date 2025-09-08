package dev.java.CadastroDePessoas.Pessoas.repository;

import dev.java.CadastroDePessoas.Pessoas.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<PessoaModel, Long> {
}
