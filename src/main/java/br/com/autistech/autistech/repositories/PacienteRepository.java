package br.com.autistech.autistech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autistech.autistech.entities.PacienteEntity;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
	
//	Optional<PacienteEntity> findByNome(String nome);
//
//	Optional<PacienteEntity> findByNomeAndIdNot(String nome, Long id);

}
