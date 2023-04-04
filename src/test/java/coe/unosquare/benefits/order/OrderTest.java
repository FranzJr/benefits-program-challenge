/*
 *  OrderTest
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
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    @Test
    void orderWithVisaMoreThan10ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(15);
        PaymentType visaPaymentType = new VisaPaymentType();
        try {
            assertEquals(0.15, payOrder(products, visaPaymentType));
        } catch (OrderPaymentTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void orderWithVisa10ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(10);
        PaymentType visaPaymentType = new VisaPaymentType();
        try {
            assertEquals(0.15, payOrder(products, visaPaymentType));
        } catch (OrderPaymentTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void orderWithVisa7ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(7);
        PaymentType visaPaymentType = new VisaPaymentType();
        try {
            assertEquals(0.10, payOrder(products, visaPaymentType));
        } catch (OrderPaymentTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void orderWithVisaLessThan7ProductsDiscountTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(5);
        PaymentType visaPaymentType = new VisaPaymentType();
        try {
            assertEquals(0.05, payOrder(products, visaPaymentType));
        } catch (OrderPaymentTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void orderWithMasterCardGreaterThan100Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(200.0);
        PaymentType masterCardPaymentType = new MasterCardPaymentType();
        try {
            assertEquals(0.17, payOrder(products, masterCardPaymentType));
        } catch (OrderPaymentTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void orderWithMasterCardBetween75And100Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(85.0);
        PaymentType masterCardPaymentType = new MasterCardPaymentType();
        try {
            assertEquals(0.12, payOrder(products, masterCardPaymentType));
        } catch (OrderPaymentTypeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void orderWithMasterCardLessThan75Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(50.0);
        PaymentType masterCardPaymentType = new MasterCardPaymentType();
        try {
            assertEquals(0.08, payOrder(products, masterCardPaymentType));
        } catch (OrderPaymentTypeException e) {
            e.printStackTrace();
        }
    }

}
