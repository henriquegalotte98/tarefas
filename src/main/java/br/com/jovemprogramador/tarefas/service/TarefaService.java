package br.com.jovemprogramador.tarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jovemprogramador.tarefas.entity.TarefaEntity;
import br.com.jovemprogramador.tarefas.repository.TarefaRepository;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }
    public TarefaEntity criar(TarefaEntity tarefa){
        if(tarefa.getConcluida()== null){
            tarefa.setConcluida(false);
        }
        return tarefaRepository.save(tarefa);
    }
    public List<TarefaEntity> listarTodas(){
        return tarefaRepository.findAll();
    }
    public TarefaEntity buscarPorId(Long id){
        return tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa não encontrada com id:"+id));
    }
    public TarefaEntity atualizar(Long id, TarefaEntity tarefaAtualizada){
        TarefaEntity tarefa = buscarPorId(id);
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
        TarefaEntity tarefa = buscarPorId(id);
        tarefaRepository.delete(tarefa);
    }
}