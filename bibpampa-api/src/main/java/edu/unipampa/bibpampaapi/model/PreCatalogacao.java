/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unipampa.bibpampaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author andreBolzan
 */
@Entity
@Table(name = "catalogacao")
public class PreCatalogacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String classificacao;
    private String cutter;
    private String autor;
    private String titulo;
    @Column(name = "subtitulo")
    private String subTitulo;
    @Column(name = "indicacao_responsabilidade")
    private String indicacaoResponsabilidade;
    private String edicao;
    private String cidade;
    private String editora;
    @Column(name = "data_publicacao")
    private int dataPublicacao;
    @Column(name = "quantidade_paginas")
    private int quantidadePaginas;
    private String resumo;

    @ManyToOne()
    @JoinColumn(name = "codigo_cdu")
    private Cdu cdu;
    private Boolean exportado;
    
    public PreCatalogacao() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getCutter() {
        return cutter;
    }

    public void setCutter(String cutter) {
        this.cutter = cutter;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getIndicacaoResponsabilidade() {
        return indicacaoResponsabilidade;
    }

    public void setIndicacaoResponsabilidade(String indicacaoResponsabilidade) {
        this.indicacaoResponsabilidade = indicacaoResponsabilidade;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(int dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Cdu getCdu() {
        return cdu;
    }

    public void setCdu(Cdu cdu) {
        this.cdu = cdu;
    }

    public Boolean getExportado() {
        return exportado;
    }

    public void setExportado(Boolean exportado) {
        this.exportado = exportado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PreCatalogacao other = (PreCatalogacao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PreCatalogacao{" + "codigo=" + codigo + ", classificacao=" + classificacao + ", cutter=" + cutter + ", autor=" + autor + ", titulo=" + titulo + ", subTitulo=" + subTitulo + ", indicacaoResponsabilidade=" + indicacaoResponsabilidade + ", edicao=" + edicao + ", cidade=" + cidade + ", editora=" + editora + ", dataPublicacao=" + dataPublicacao + ", quantidadePaginas=" + quantidadePaginas + ", resumo=" + resumo + ", cdu=" + cdu + ", exportado=" + exportado + '}';
    }
}
