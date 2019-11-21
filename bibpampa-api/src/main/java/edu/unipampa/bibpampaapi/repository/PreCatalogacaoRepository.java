/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unipampa.bibpampaapi.repository;

import edu.unipampa.bibpampaapi.model.PreCatalogacao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author andreBolzan
 */
public interface PreCatalogacaoRepository extends JpaRepository<PreCatalogacao, Long>{
    
    @Transactional
    @Modifying
    @Query("UPDATE PreCatalogacao pc "
            + "SET pc.exportado = :true "
            + "WHERE pc.codigo = :codigo")
    public void alterarExportado(@Param("true") Boolean exportado, @Param("codigo") Long codigo);
    
    public List<PreCatalogacao> findAllByExportadoTrue();
    
    public List<PreCatalogacao> findAllByExportadoFalse();
}
