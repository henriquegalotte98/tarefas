package br.com.jovemprogramador.tarefas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="tarefas")
public class TarefasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(length = 500)
    private String descricao;

    @Column(nullable = false)
    private Boolean concluida;

    public TarefasEntity(){

    }
    public TarefasEntity(Long id, String titulo, String descricao, Boolean concluida){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;

    }



}
