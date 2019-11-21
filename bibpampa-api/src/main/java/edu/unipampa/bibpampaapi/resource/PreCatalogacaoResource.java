/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unipampa.bibpampaapi.resource;

import edu.unipampa.bibpampaapi.model.PreCatalogacao;
import edu.unipampa.bibpampaapi.repository.PreCatalogacaoRepository;
import edu.unipampa.bibpampaapi.service.PreCatalogacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andreBolzan
 */
@CrossOrigin(origins = "http://localhost:8090/bibpampa")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pre-catalogacoes")
public class PreCatalogacaoResource {
    
    @Autowired
    private PreCatalogacaoRepository preCatalogacaoRepository;
    
    @Autowired
    private PreCatalogacaoService preCatalogacaoService;
    
    @PostMapping
    public ResponseEntity<PreCatalogacao> salvar(@RequestBody PreCatalogacao preCatalogacao){
        PreCatalogacao catalogacaoSalva = preCatalogacaoService.salvarPrecatalogacoes(preCatalogacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogacaoSalva);
    }
    
    @GetMapping("/{codigo}")
    public PreCatalogacao buscarPorCodigo(@PathVariable Long codigo){
        return preCatalogacaoRepository.findById(codigo).get();
    }
}
