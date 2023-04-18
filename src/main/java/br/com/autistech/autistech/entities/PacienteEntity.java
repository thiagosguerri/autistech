package br.com.autistech.autistech.entities;

import java.time.LocalDate;

import br.com.autistech.autistech.exceptions.BadRequestBussinessException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
//@SequenceGenerator(name= "paciente", sequenceName= "SQ_PACIENTE", allocationSize = 1)
@Table(name = "tb_paciente")
public class PacienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(length = 100, name = "nome", unique = true)
	private String nome;
	
	@Column(name= "CPF", length = 11, unique = true)
    private String cpf;
    
	@Column(name = "nascimento", length = 8, nullable = true)
    private LocalDate dataNascimento;
    
	@Column(name = "genero")
    private String genero;
    
	@Column(name = "endereco")
    private String endereco;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "contato_emergencia")
    private String contatoEmergencia;
        

	public void setNome(String nome) {
		if (nome == null || "".equals(nome)) {
			throw new BadRequestBussinessException("O campo Nome é obrigatório!");
		}

		if (nome.length() > 1000) {
			throw new BadRequestBussinessException("O campo Nome deve ter no máximo 100 caracteres!");
		}

		this.nome = nome;
	}
    
    // ADIÇÕES DE ATRIBUTOS POSSÍVEIS FUTURAMENTE
    
//    private String historicoMedico;
//    private String alergias;
//    private String medicamentosAtuais;
//    private String problemasDeSaudeAtuais;
//    private String examesMedicosAnteriores;

}
