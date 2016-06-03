/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tarefas.modelo;

import java.util.Calendar;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CCE
 */
public class Tarefa {

    private Long id;
    
    @NotNull @Size(min=5)
    private String descricao;
    private boolean finalizado;
    private Calendar dataFinalizacao = Calendar.getInstance();

    public Tarefa() {
    }

    public Tarefa(String descricao, boolean finalizado, Calendar dataFinalizacao) {
        this.descricao = descricao;
        this.finalizado = finalizado;
        this.dataFinalizacao = dataFinalizacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
    
    
    
}
