package aharon.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsServiceTest {

    @Test
    void getProducts() {

        // given
        ProductsService service = new ProductsServiceFactory().create();

        // when
        ProductsResponse products = service.getProducts()
            .blockingGet();

        // then
        assertEquals(30, products.products.length);
    }
}