package br.com.autistech.autistech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autistech.autistech.dtos.inputs.ProntuarioInput;
import br.com.autistech.autistech.entities.MedicoEntity;
import br.com.autistech.autistech.entities.PacienteEntity;
import br.com.autistech.autistech.entities.ProntuarioEntity;
import br.com.autistech.autistech.exceptions.NotFoundBussinessException;
import br.com.autistech.autistech.repositories.MedicoRepository;
import br.com.autistech.autistech.repositories.PacienteRepository;
import br.com.autistech.autistech.repositories.ProntuarioRepository;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;
    
    @Autowired
    private MedicoRepository medicoRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<ProntuarioEntity> listarTodos() {
        return prontuarioRepository.findAll();
    }

    public ProntuarioEntity buscarPorId(Long id) {
        return prontuarioRepository.findById(id).orElseThrow(() -> new NotFoundBussinessException("Prontuario " + id + " não encontrado."));
    }

    public ProntuarioEntity salvar(ProntuarioInput input) {
    	ProntuarioEntity prontuario = new ProntuarioEntity();
    	PacienteEntity pacienteEncontrado = pacienteRepository.findById(input.getPacienteId()).get();
    	MedicoEntity medicoEncontrado = medicoRepository.findById(input.getMedicoResponsavelId()).get();
    	prontuario.setPaciente(pacienteEncontrado);
    	prontuario.setMedicoResponsavel(medicoEncontrado);
    	prontuario.setSintomas(input.getSintomas());
    	prontuario.setDataAtendimento(input.getDataAtendimento());
    	prontuario.setDiagnostico(input.getDiagnostico());
    	prontuario.setPrescricaoMedica(input.getPrescricaoMedica());
    	
    	
        return prontuarioRepository.save(prontuario);
    }

    public void excluir(Long id) {
    	prontuarioRepository.deleteById(id);
    }

    public ProntuarioEntity atualizar(Long id, ProntuarioEntity prontuarioAtualizado) {
    	ProntuarioEntity prontuario = prontuarioRepository.findById(id).orElseThrow(() -> new NotFoundBussinessException("Prontuario " + id + " não encontrado."));
        if (prontuario == null) {
            return null;
        }        
        
        prontuario.setSintomas(prontuarioAtualizado.getSintomas());
        prontuario.setPrescricaoMedica(prontuarioAtualizado.getPrescricaoMedica());
        prontuario.setDiagnostico(prontuarioAtualizado.getDiagnostico());
        prontuario.setDataAtendimento(prontuarioAtualizado.getDataAtendimento());
        prontuario.setPaciente(prontuarioAtualizado.getPaciente());
        prontuario.setMedicoResponsavel(prontuarioAtualizado.getMedicoResponsavel());
        
        return prontuarioRepository.save(prontuario);
    }
    
 
}
