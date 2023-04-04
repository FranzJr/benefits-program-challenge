package coe.unosquare.benefits.payment;

/**
 * This class represents a Visa payment type that can be used to calculate a
 * discount for an order.
 * It implements the PaymentType interface and overrides the applyDiscount
 * method to apply the discount rules for Visa orders.
 */
public class VisaPaymentType implements PaymentType {

    /**
     * Calculates the discount for a Visa order based on the total products and
     * total amount before the discount.
     *
     * @param totalProducts the total number of products in the order.
     * @param totalAmount   the total amount to pay for the order before discount.
     * @return the discount to be applied to the order.
     */
    @Override
    public Double applyDiscount(Integer totalProducts, Double totalAmount) {
        if (totalProducts >= 10) {
            return 0.15;
        } else if (totalProducts >= 7) {
            return 0.10;
        } else {
            return 0.05;
        }
    }
}
