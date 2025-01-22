package com.neoris.account.catalogue.services;


import com.neoris.account.catalogue.entities.CatalogueValueEntity;
import com.neoris.account.catalogue.vo.CatalogueValue.UpdateCatalogueValue;

public interface ICatalogueValueService {

    CatalogueValueEntity findById(Long catalogueValueId);

    void update(Long catalogueValueId, UpdateCatalogueValue updateCatalogueValue);

    void delete(Long catalogueValueId);
}
