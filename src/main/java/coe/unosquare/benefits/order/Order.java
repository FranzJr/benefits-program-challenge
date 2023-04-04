/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.payment.MasterCardPaymentType;
import coe.unosquare.benefits.payment.PaymentType;
import coe.unosquare.benefits.payment.VisaPaymentType;
import coe.unosquare.benefits.product.Product;
import java.util.Map;

/**
 * The type Order.
 */
public class Order {
    /** Store the final list of products and quantity for each product. **/
    private final Map<Product, Integer> products;

    /**
     * Instantiates a new Order.
     *
     * @param productsMap the list of products added to the order
     */
    public Order(final Map<Product, Integer> productsMap) {
        products = productsMap;
    }

    /**
     * Pay double.
     *
     * @param paymentType the payment type
     * @return the double
     * @throws OrderPaymentTypeException
     */
    public Double pay(final PaymentType paymentType) throws OrderPaymentTypeException {

        if (!(paymentType instanceof VisaPaymentType || paymentType instanceof MasterCardPaymentType)) {
            throw new OrderPaymentTypeException("Unsupported payment type: " + paymentType.getClass().getSimpleName());
        }

        Integer totalProducts = products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity);

        Double totalAmount = products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();

        Double discount = paymentType.applyDiscount(totalProducts, totalAmount);

        return totalAmount - totalAmount * discount;
    }

    /**
     * Print.
     */
    public void print() {
         products.forEach((product, quantity) ->
                 System.out.println("Product:{" + product.getName() + ","
                         + product.getPrice() + ","
                         + product.getType()
                         + "},Quantity:" + quantity
                         + ",Total:" + product.getPrice() * quantity));
    }
}
