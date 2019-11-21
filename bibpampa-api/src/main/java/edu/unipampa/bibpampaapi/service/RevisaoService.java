/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unipampa.bibpampaapi.service;

import edu.unipampa.bibpampaapi.model.PreCatalogacao;
import edu.unipampa.bibpampaapi.repository.PreCatalogacaoRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andreBolzan
 */
@Service
public class RevisaoService {
    
    @Autowired
    private PreCatalogacaoRepository preCatalogacaoRepository;
    
    private final String QUEBRA_LINHA = "\n";
    private final String ESPACO = " ";
    private final String LEADER = "000 00000nam a2200000 a 4500";
    private final String IDENTIFICADOR_LIVRO = "008 191006s|||| bl|||||||||||||||||por|u";
    private final String CAMPO_CDU = "080 __|2";
    private final String CAMPO_CLASSIFICACAO = "090 __|a";
    private final String SUBCAMPO_CUTTER = "|b";
    private final String CAMPO_AUTOR = "100 1_|a";
    private final String CAMPO_TITULO = "245 10|a";
    private final String SUBCAMPO_SUBTITULO = "|b";
    private final String SUBCAMPO_INDICACAO_OBRA = "|c";
    private final String CAMPO_EDICAO = "250 __|a";
    private final String CAMPO_CIDADE = "260 __|a";
    private final String SUBCAMPO_EDITORA = "|b";
    private final String SUBCAMPO_DATA_PUBLICACAO = "|c";
    private final String CAMPO_NUM_PAGINAS = "300 __|a";  
    private final String CAMPO_RESUMO = "520 __|a";
    
    public void gerarArquivoImportacao(List<PreCatalogacao> catalogacoes) {
        String horaCriacao = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        
        StringBuilder sb = new StringBuilder();
        
        try {
            
            File file = new File("C:\\bibpampa\\arquivo-" + horaCriacao + ".txt");
            file.getParentFile().mkdirs();
            FileOutputStream fileOutPut = new FileOutputStream(file);
            
            PrintWriter pw = new PrintWriter(fileOutPut);
            
            for (PreCatalogacao catalogacao : catalogacoes) {
                sb.append(LEADER).append(QUEBRA_LINHA)
                        .append(IDENTIFICADOR_LIVRO).append(QUEBRA_LINHA)
                        .append(CAMPO_CDU).append(catalogacao.getCdu().getDescricao()).append(QUEBRA_LINHA)
                        .append(CAMPO_CLASSIFICACAO).append(catalogacao.getClassificacao())
                        .append(SUBCAMPO_CUTTER).append(catalogacao.getCutter()).append(QUEBRA_LINHA)
                        .append(CAMPO_AUTOR).append(catalogacao.getCutter()).append(QUEBRA_LINHA)
                        .append(CAMPO_TITULO).append(catalogacao.getAutor())
                        .append(SUBCAMPO_SUBTITULO).append(catalogacao.getSubTitulo())
                        .append(SUBCAMPO_INDICACAO_OBRA)
                        .append(catalogacao.getIndicacaoResponsabilidade()).append(QUEBRA_LINHA)
                        .append(CAMPO_EDICAO).append(catalogacao.getEdicao()).append(QUEBRA_LINHA)
                        .append(CAMPO_CIDADE).append(catalogacao.getCidade())
                        .append(SUBCAMPO_EDITORA).append(catalogacao.getEditora())
                        .append(SUBCAMPO_DATA_PUBLICACAO).append(catalogacao.getDataPublicacao()).append(QUEBRA_LINHA)
                        .append(CAMPO_NUM_PAGINAS).append(catalogacao.getQuantidadePaginas()).append(QUEBRA_LINHA)
                        .append(CAMPO_RESUMO).append(catalogacao.getResumo()).append(QUEBRA_LINHA)
                        .append(QUEBRA_LINHA);
            }
            pw.append(sb);
            pw.close();
            fileOutPut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RevisaoService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RevisaoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PreCatalogacao atualizar(Long codigo, PreCatalogacao catalogacao) {
        PreCatalogacao catalogacaoSalva = preCatalogacaoRepository.findById(codigo).get();
        BeanUtils.copyProperties(catalogacao, catalogacaoSalva, "codigo");
        return preCatalogacaoRepository.save(catalogacaoSalva);
    }
    
    public void deletar(List<PreCatalogacao> catalogacoes){
        catalogacoes.forEach((catalogacao) -> { 
        preCatalogacaoRepository.delete(catalogacao);
    });
    }
    
    public void setarExportados(List<PreCatalogacao> catalogacoes){
        catalogacoes.forEach((catalogacao) -> {
            preCatalogacaoRepository.alterarExportado(catalogacao.getExportado(), catalogacao.getCodigo());
        });
    }
    
    
}
