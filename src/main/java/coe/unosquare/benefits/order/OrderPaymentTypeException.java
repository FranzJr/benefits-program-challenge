package coe.unosquare.benefits.order;

/**
 * 
 * An exception class to handle errors related to payment types in Order class.
 */
public class OrderPaymentTypeException extends Exception {

    /**
     * 
     * Constructs a new OrderPaymentTypeException with the given message.
     * 
     * @param message the detail message.
     */
    public OrderPaymentTypeException(String message) {
        super(message);
    }
}