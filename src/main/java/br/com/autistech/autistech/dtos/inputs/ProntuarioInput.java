package br.com.autistech.autistech.dtos.inputs;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProntuarioInput {

    
    private String sintomas;
    
    private String prescricaoMedica;
    
    private String diagnostico;
    
    private LocalDate dataAtendimento;
    
    private Long pacienteId;
    
    private Long medicoResponsavelId;	
}
