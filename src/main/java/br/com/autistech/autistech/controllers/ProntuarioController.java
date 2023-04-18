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

import br.com.autistech.autistech.dtos.inputs.ProntuarioInput;
import br.com.autistech.autistech.entities.ProntuarioEntity;
import br.com.autistech.autistech.services.ProntuarioService;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioController {
	
	@Autowired
    private ProntuarioService prontuarioService;

    @GetMapping("")
    public List<ProntuarioEntity> listarTodos() {
        return prontuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ProntuarioEntity buscarPorId(@PathVariable Long id) {
        return prontuarioService.buscarPorId(id);
    }

    @PostMapping()
    public ProntuarioEntity salvar(@RequestBody ProntuarioInput input) {
    	return prontuarioService.salvar(input);
    }

    
    @PutMapping("/{id}")
    public ProntuarioEntity atualizar(@PathVariable Long id, @RequestBody ProntuarioEntity prontuarioAtualizado) {
        return prontuarioService.atualizar(id, prontuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
    	prontuarioService.excluir(id);
    }

}
