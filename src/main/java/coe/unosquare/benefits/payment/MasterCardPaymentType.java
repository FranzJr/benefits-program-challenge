package coe.unosquare.benefits.payment;

public class MasterCardPaymentType implements PaymentType {

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
