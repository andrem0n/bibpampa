/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unipampa.bibpampaapi.service;

import edu.unipampa.bibpampaapi.model.PreCatalogacao;
import edu.unipampa.bibpampaapi.repository.PreCatalogacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andreBolzan
 */
@Service
public class PreCatalogacaoService {

    @Autowired
    private PreCatalogacaoRepository preCatalogacaoRepository;

    public PreCatalogacao salvarPrecatalogacoes(PreCatalogacao catalogacao) {
        catalogacao.setExportado(Boolean.FALSE);
        switch (catalogacao.getCdu().getCodigo()) {
            case 1:
                catalogacao.setClassificacao("869.0(81)");
                break;
            case 2:
                catalogacao.setClassificacao("820(73)");
                break;
            default:
                catalogacao.setClassificacao("820");
                break;
        }
        preCatalogacaoRepository.save(catalogacao);
        return catalogacao;
    }
}
