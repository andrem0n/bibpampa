/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unipampa.bibpampaapi.resource;

import edu.unipampa.bibpampaapi.model.PreCatalogacao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.unipampa.bibpampaapi.service.RevisaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import edu.unipampa.bibpampaapi.repository.PreCatalogacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author andreBolzan
 */
@CrossOrigin(origins = "http://localhost:8090/bibpampa")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/revisoes")
public class RevisaoResource {
    
    @Autowired
    private PreCatalogacaoRepository catalogacaoRepository;
    
    @Autowired
    private RevisaoService revisaoService;
    
    @GetMapping
    public List<PreCatalogacao> listar() {
        return catalogacaoRepository.findAll();
    }
    
    @PostMapping("/exportar-pre-catalogacoes")
    public void criarArquivoImportacao(@RequestBody List<PreCatalogacao> preCatalogacoes) {
        revisaoService.gerarArquivoImportacao(preCatalogacoes);
    }
    
    @PutMapping("/mudar-status")
    public void setarPrecatalogacoesParaTrue(@RequestBody List<PreCatalogacao> preCatalogacoes) {
        revisaoService.setarExportados(preCatalogacoes);
    }
    
    @PostMapping("/deletar")
    public void deletar(@RequestBody List<PreCatalogacao> preCatalogacoes) {
        revisaoService.deletar(preCatalogacoes);
    }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<PreCatalogacao> atualizar(@PathVariable Long codigo, @RequestBody PreCatalogacao catalogacao) {
        PreCatalogacao catalogacaoSalva = revisaoService.atualizar(codigo, catalogacao);
        return ResponseEntity.ok(catalogacaoSalva);
    }
    
    @GetMapping("/nao-exportados")
    public List<PreCatalogacao> listarNaoExportados() {
        return catalogacaoRepository.findAllByExportadoFalse();
    }
    
    @GetMapping("/exportados")
    public List<PreCatalogacao> listarExportados() {
        return catalogacaoRepository.findAllByExportadoTrue();
    }
}
