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

import br.com.autistech.autistech.entities.MedicoEntity;
import br.com.autistech.autistech.services.MedicoService;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("")
    public List<MedicoEntity> listarTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public MedicoEntity buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id);
    }

    @PostMapping("")
    public MedicoEntity salvar(@RequestBody MedicoEntity medico) {
        return medicoService.salvar(medico);
    }

    
    @PutMapping("/{id}")
    public MedicoEntity atualizar(@PathVariable Long id, @RequestBody MedicoEntity medicoAtualizado) {
        return medicoService.atualizar(id, medicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
    	medicoService.excluir(id);
    }
}
