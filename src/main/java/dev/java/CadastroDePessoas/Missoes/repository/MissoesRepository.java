package dev.java.CadastroDePessoas.Missoes.repository;

import dev.java.CadastroDePessoas.Missoes.model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
