package br.com.autistech.autistech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autistech.autistech.entities.PacienteEntity;
import br.com.autistech.autistech.repositories.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;    

    public List<PacienteEntity> listarTodos() {
        return pacienteRepository.findAll();
    }

    public PacienteEntity buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public PacienteEntity salvar(PacienteEntity paciente) {
        return pacienteRepository.save(paciente);
    }

    public void excluir(Long id) {
        pacienteRepository.deleteById(id);
    }

    public PacienteEntity atualizar(Long id, PacienteEntity pacienteAtualizado) {
    	PacienteEntity paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente == null) {
            return null;
        }
        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setCpf(pacienteAtualizado.getCpf());
        paciente.setDataNascimento(pacienteAtualizado.getDataNascimento());
        paciente.setEndereco(pacienteAtualizado.getEndereco());
        paciente.setTelefone(pacienteAtualizado.getTelefone());
        paciente.setEmail(pacienteAtualizado.getEmail());
        paciente.setContatoEmergencia(pacienteAtualizado.getContatoEmergencia());
        return pacienteRepository.save(paciente);
    }
}
