package br.com.autistech.autistech.dtos.inputs;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicoInput {
	
	@NotNull
	private String nome;
	
	@CPF
	private String cpf;
	
	@Email(message = "O email está inválido", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	private String email;
	
	private LocalDate nascimento;
	
	private Integer crm;	
	
	private String endereco;	
	
	private String telefone;
	
	private String especialidade;

}
