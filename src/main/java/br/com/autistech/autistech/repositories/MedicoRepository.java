package br.com.autistech.autistech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autistech.autistech.entities.MedicoEntity;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
	
//	Optional<MedicoEntity> findByNome(String nome);
//
//	Optional<MedicoEntity> findByNomeAndIdNot(String nome, Long id);

}
