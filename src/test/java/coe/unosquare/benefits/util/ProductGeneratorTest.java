package coe.unosquare.benefits.util;

import coe.unosquare.benefits.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductGeneratorTest {

    @Test
    @DisplayName("Given a number when generate products then returns map with expected size")
    void generateProducts_GivenNumber_ReturnsMapWithExpectedSize() {
        final int expectedSize = 5;
        final Map<Product, Integer> result = ProductGenerator.generateProducts(expectedSize);

        assertNotNull(result);
        assertEquals(expectedSize, result.size());
    }

    @Test
    @DisplayName("Given a number when generate products then returns map with products with a quantity of 1")
    void generateProducts_GivenNumber_ReturnsMapWithProductsQuantityOfOne() {
        final int expectedSize = 5;
        final Map<Product, Integer> result = ProductGenerator.generateProducts(expectedSize);

        assertNotNull(result);
        result.forEach((product, quantity) -> assertEquals(1, quantity));
    }

    @Test
    @DisplayName("Given a number when generate products then returns map with products with prices between 0 and 10")
    void generateProducts_GivenNumber_ReturnsMapWithProductsWithPricesBetween0and10() {
        final int expectedSize = 5;
        final Map<Product, Integer> result = ProductGenerator.generateProducts(expectedSize);

        assertNotNull(result);
        result.forEach((product, quantity) -> {
            final double price = product.getPrice();
            assertEquals(1, Double.compare(price, 0.0));
            assertEquals(-1, Double.compare(price, 10.0));
        });
    }



}
