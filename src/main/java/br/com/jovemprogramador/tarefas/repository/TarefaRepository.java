package br.com.jovemprogramador.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jovemprogramador.tarefas.entity.TarefaEntity;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Long>{
    
}
