package com.neoris.account.catalogue.repositories;

import com.neoris.account.catalogue.entities.CatalogueTypeEntity;
import com.neoris.account.catalogue.vo.CatalogueType.CreateCatalogueType;
import com.neoris.account.catalogue.vo.CatalogueType.QueryCatalogueType;
import com.neoris.account.catalogue.vo.CatalogueType.UpdateCatalogueType;
import com.neoris.account.common.repositories.IQueryDslBaseRepository;

import java.util.List;

/**
 * Catalogue repository
 *
 * @author Kevin
 * @version 1.0
 */
public interface ICatalogueTypeRepository extends IQueryDslBaseRepository<CatalogueTypeEntity> {

    /**
     * Create new Catalogue Type
     *
     * @param createCatalogueType CreateCatalogueType
     * @return New catalogue type
     */
    CatalogueTypeEntity create(CreateCatalogueType createCatalogueType);

    /**
     * Find Catalogue by Id
     *
     * @param catalogueTypeId Long
     * @return CatalogueType
     */
    CatalogueTypeEntity findById(Long catalogueTypeId);

    /**
     * Update Catalogue Type
     *
     * @param catalogueTypeId     Catalogue Id
     * @param updateCatalogueType Catalogue type to enable
     */
    void updateEntity(Long catalogueTypeId, UpdateCatalogueType updateCatalogueType);

    /**
     * Inactive Catalogue Type
     *
     * @param catalogueTypeId Long
     */
    void inactive(Long catalogueTypeId);

    /**
     * Find all Catalogues
     *
     * @return List of Catalogue Types
     */
    List<CatalogueTypeEntity> findAll(QueryCatalogueType query);
}
