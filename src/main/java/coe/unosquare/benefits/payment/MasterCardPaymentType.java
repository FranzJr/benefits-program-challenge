package coe.unosquare.benefits.payment;

/**
 * This class represents a MasterCard payment type that can be used to calculate
 * a discount for an order.
 * It implements the PaymentType interface and overrides the applyDiscount
 * method to apply the discount rules for MasterCard orders.
 */
public class MasterCardPaymentType implements PaymentType {

    /**
     * Calculates the discount for a MasterCard order based on the total products
     * and total amount before the discount.
     *
     * @param totalProducts the total number of products in the order.
     * @param totalAmount   the total amount to pay for the order before discount.
     * @return the discount to be applied to the order.
     */
    @Override
    public Double applyDiscount(Integer totalProducts, Double totalAmount) {
        if (totalAmount >= 100) {
            return 0.17;
        } else if (totalAmount >= 75) {
            return 0.12;
        } else {
            return 0.08;
        }
    }
}
