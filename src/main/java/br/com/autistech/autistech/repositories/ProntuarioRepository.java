package br.com.autistech.autistech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autistech.autistech.entities.ProntuarioEntity;

@Repository
public interface ProntuarioRepository extends JpaRepository<ProntuarioEntity, Long> {
	
//	List<ProntuarioEntity> findAllByPacienteId(Long idPaciente);
//	
//	List<ProntuarioEntity> findAllByMedicoId(Long idMedico);

}
