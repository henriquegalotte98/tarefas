package br.com.jovemprogramador.tarefas.controller;

import java.util.List;
import br.com.jovemprogramador.tarefas.entity.TarefaEntity;
import br.com.jovemprogramador.tarefas.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefasController {

    private final TarefaService tarefaService;

    public TarefasController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaEntity> criar(@RequestBody TarefaEntity tarefa){
        TarefaEntity novaTarefa = tarefaService.criar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaEntity>> listarTodas(){
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaEntity> buscarPorId(@PathVariable Long id){
        TarefaEntity tarefa = tarefaService.buscarPorId(id);
        return ResponseEntity.ok(tarefa);
    }

    @PutMapping("/{id}")   
    public ResponseEntity<TarefaEntity> atualizar(@PathVariable Long id, @RequestBody TarefaEntity tarefa){
        TarefaEntity tarefaAtualizada = tarefaService.atualizar(id, tarefa);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
