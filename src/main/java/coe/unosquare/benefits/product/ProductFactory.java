package coe.unosquare.benefits.product;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory class for creating Product objects.
 */
public final class ProductFactory {

    /** Private constructor to prevent creating instances of this utility class. */
    private ProductFactory() { }

    /**
     * Creates a map of Product objects, given an array of product data.
     * The array should have rows in the format of: {name, price, type}.
     * The type should be a number between 1 and 3, inclusive.
     * Returns a map of Product objects, where the keys are the product names.
     *
     * @param data an array of product data in the format {name, price, type}
     * @return a map of Product objects, where the keys are the product names
     * @throws IllegalArgumentException if the data array is null or has invalid data
     */
    public static Map<String, Product> createProducts(final String[][] data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Data array cannot be null");
        }

        Map<String, Product> products = new HashMap<>();

        for (String[] row : data) {
            if (row == null || row.length != 3) {
                throw new IllegalArgumentException("Invalid data row: " + row);
            }

            String name = row[0];
            double price;
            try {
                price = Double.parseDouble(row[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid price value: " + row[1], e);
            }

            int type;
            try {
                type = Integer.parseInt(row[2]);
                if (type < 1 || type > 3) {
                    throw new IllegalArgumentException("Invalid product type: " + type);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid product type: " + row[2], e);
            }

            products.put(name, new Product(name, price, type));
        }

        return products;
    }
}
