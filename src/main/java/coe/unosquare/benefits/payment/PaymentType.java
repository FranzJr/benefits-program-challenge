package coe.unosquare.benefits.payment;

public interface PaymentType {
    Double applyDiscount(Integer totalProducts, Double totalAmount);
}
