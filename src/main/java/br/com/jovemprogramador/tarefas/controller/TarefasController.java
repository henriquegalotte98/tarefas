package br.com.jovemprogramador.tarefas.controller;
import java.util.List;
import br.com.jovemprogramador.tarefas.entity.TarefasEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefasController {
    private final TarefaService TarefaService;
    public TarefasController(TarefaService TarefaService){
        this.TarefaService = tarefaService;
    }
    public ResponseEntity<TarefaEntity>criar(@RequestBody TarefaEntity tarefa){
        TarefaEntity novaTarefa = tarefaService.criar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaEntity>>listarTodas(){
        return ResponseEntity.ok(tarefaService.listarTodas());

    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaEntity>buscarPorId(@PathVariable Long id,@RequestBody TarefaEntity tarefa){

    }

    @PutMapping("/{id}")   
    public ResponseEntity<TarefaEntity>atualizar(@PathVariable Long id, @RequestBody TarefaEntity tarefa){

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
