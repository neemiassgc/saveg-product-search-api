package com.api.service;

import com.api.entity.Product;
import com.api.repository.ProductRepository;
import com.api.repository.ProductRepositoryCustomImpl;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductRepositoryCustomImplTest {

    private ProductRepositoryCustomImpl productRepositoryCustomImplUnderTest;
    private ProductRepository productRepository;
    private ProductExternalService productExternalService;

    // resources for testing
    private Product defaultProduct;

    @BeforeAll
    void init() {
        this.defaultProduct = Product.builder()
            .description("OLEO MARIA")
            .barcode("7896036093085")
            .sequenceCode(1184)
            .build();
    }

    @BeforeEach
    void preset() {
        this.productRepository = mock(ProductRepository.class);
        this.productExternalService = mock(ProductExternalService.class);
        this.productRepositoryCustomImplUnderTest =
            new ProductRepositoryCustomImpl(this.productExternalService);
        this.productRepositoryCustomImplUnderTest.setProductRepository(productRepository);
    }
}
