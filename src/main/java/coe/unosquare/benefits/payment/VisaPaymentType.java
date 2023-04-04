package coe.unosquare.benefits.payment;

public class VisaPaymentType implements PaymentType {

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
