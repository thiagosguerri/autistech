package br.com.autistech.autistech.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@SequenceGenerator(name= "prontuario", sequenceName= "SQ_PRONTUARIO", allocationSize = 1)
@Table(name = "tb_prontuario")
public class ProntuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;	
    
    @Column(name = "sintomas")
    private String sintomas;
    
    @Column(name = "prescricao_medica")
    private String prescricaoMedica;
    
    @Column(name = "diagnostico")
    private String diagnostico;
    
    @Column(name = "dt_Atendimento")
    private LocalDate dataAtendimento;
    
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;    
    
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoEntity medicoResponsavel;	

}
