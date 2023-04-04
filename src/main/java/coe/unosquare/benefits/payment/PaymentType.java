package coe.unosquare.benefits.payment;

/**
 * This interface represents a payment type that can be used to calculate a
 * discount for an order.
 * Any class that implements this interface must implement the applyDiscount
 * method.
 */
public interface PaymentType {

    /**
     * Calculates the discount for an order based on the total products and total
     * amount before the discount.
     *
     * @param totalProducts the total number of products in the order.
     * @param totalAmount   the total amount to pay for the order before discount.
     * @return the discount to be applied to the order.
     */
    Double applyDiscount(Integer totalProducts, Double totalAmount);
}
