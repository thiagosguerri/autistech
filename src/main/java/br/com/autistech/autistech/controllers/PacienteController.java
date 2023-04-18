package br.com.autistech.autistech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autistech.autistech.entities.PacienteEntity;
import br.com.autistech.autistech.services.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
	
	@Autowired
    private PacienteService pacienteService;

    @GetMapping("")
    public List<PacienteEntity> listarTodos() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public PacienteEntity buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id);
    }

    @PostMapping("")
    public PacienteEntity salvar(@RequestBody PacienteEntity paciente) {
        return pacienteService.salvar(paciente);
    }

    
    @PutMapping("/{id}")
    public PacienteEntity atualizar(@PathVariable Long id, @RequestBody PacienteEntity pacienteAtualizado) {
        return pacienteService.atualizar(id, pacienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
    	pacienteService.excluir(id);
    }

}
