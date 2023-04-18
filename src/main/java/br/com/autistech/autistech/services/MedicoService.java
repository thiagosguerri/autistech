package br.com.autistech.autistech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autistech.autistech.entities.MedicoEntity;
import br.com.autistech.autistech.repositories.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public List<MedicoEntity> listarTodos() {
		return medicoRepository.findAll();
	}
	
	public MedicoEntity buscarPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public MedicoEntity salvar(MedicoEntity medico) {
        return medicoRepository.save(medico);
    }

    public void excluir(Long id) {
    	medicoRepository.deleteById(id);
    }

    public MedicoEntity atualizar(Long id, MedicoEntity medicoAtualizado) {
    	MedicoEntity medico = medicoRepository.findById(id).orElse(null);
        if (medico == null) {
            return null;
        }
        medico.setNome(medicoAtualizado.getNome());
        medico.setCpf(medicoAtualizado.getCpf());
        medico.setEmail(medicoAtualizado.getEmail());
        medico.setNascimento(medicoAtualizado.getNascimento());
        medico.setCrm(medicoAtualizado.getCrm());
        medico.setEndereco(medicoAtualizado.getEndereco());
        medico.setTelefone(medicoAtualizado.getTelefone());
        medico.setEspecialidade(medicoAtualizado.getEspecialidade());
        return medicoRepository.save(medico);
    }

}
