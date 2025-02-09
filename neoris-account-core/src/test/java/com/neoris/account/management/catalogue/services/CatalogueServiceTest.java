package com.neoris.account.management.catalogue.services;

import com.neoris.account.catalogue.entities.CatalogueTypeEntity;
import com.neoris.account.catalogue.repositories.ICatalogueTypeRepository;
import com.neoris.account.catalogue.services.CatalogueService;
import com.neoris.account.catalogue.vo.CatalogueType.CreateCatalogueType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CatalogueServiceTest {
    @Mock
    private ICatalogueTypeRepository catalogueTypeRepository;

    @InjectMocks
    private CatalogueService catalogueService;

    private CatalogueTypeEntity catalogueType;

    @BeforeEach
    void setup(){
        catalogueType = CatalogueTypeEntity.builder()
                .catalogueTypeId(1l)
                .code("CODE-ONE")
                .name("code one")
                .build();
    }

    @DisplayName("Test to save CatalogueType")
    @Test
    void testSaveCatalogueTypeTest(){
        CreateCatalogueType createCatalogueType = CreateCatalogueType.builder()
                        .code("CODE-ONE")
                                .name("code one")
                                        .build();
        given(catalogueTypeRepository.create(createCatalogueType)).willReturn(catalogueType);
        CatalogueTypeEntity catalogueTypeEntity = catalogueService.createType(createCatalogueType);
        assertNotNull(catalogueTypeEntity);
    }
}
