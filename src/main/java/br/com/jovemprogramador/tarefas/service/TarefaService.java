package br.com.jovemprogramador.tarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jovemprogramador.tarefas.entity.TarefasEntity;
import br.com.jovemprogramador.tarefas.repository.TarefaRepository;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }
    public TarefasEntity criar(TarefaEntity tarefa){
        if(tarefa.getConcluida()== null){
            tarefa.setConcluida(false);
        }
        return tarefaRepository.findAll();
    
    }
    public List<TarefaEntity> listarTodas(){
        return tarefaRepository.findAll();
    }
    public TarefasEntity buscarPorId(Long id){
        return tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada com id:"+id));
    }
    public TarefasEntity atualizar(Long id, TarefasEntity tarefaAtualizada){
        TarefasEntity tarefa = buscarPorId(id);
        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        if(tarefaAtualizada.getConcluida()==null){
            tarefa.setConcluida(false);
        }else{
            tarefa.setConcluida(tarefaAtualizada.getConcluida());
        }
        return tarefaRepository.save(tarefa);
    }
    public void deletar(Long id){
        TarefasEntity tarefa = buscarPorId(id);
        tarefaRepository.delete(tarefa);
    }


}
