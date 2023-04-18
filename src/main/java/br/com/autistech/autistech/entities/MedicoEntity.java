package br.com.autistech.autistech.entities;

import java.time.LocalDate;

import br.com.autistech.autistech.exceptions.BadRequestBussinessException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@SequenceGenerator(name= "medico", sequenceName= "SQ_MEDICO", allocationSize = 1)
@Table(name = "tb_medico")
public class MedicoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(length = 100, name = "nome", unique = true)
	private String nome;
	
	@Column(length = 11, unique = true)
	private String cpf;
		
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "nascimento")
	private LocalDate nascimento;

	@Column(name= "CRM", unique = true)
	private Integer crm;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "telefone")
	private String telefone;

	@Column(length = 1000, name = "especialidade")
	private String especialidade;
		
	public void setNome(String nome) {
		if (nome == null || "".equals(nome)) {
			throw new BadRequestBussinessException("O campo Nome é obrigatório!");
		}

		if (nome.length() > 1000) {
			throw new BadRequestBussinessException("O campo Nome deve ter no máximo 100 caracteres!");
		}

		this.nome = nome;
	}
}
