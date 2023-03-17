package org.example;

public final class DiscountService {
    public double createDiscount(int value){
        return value>=150?value*0.15:value*0.05;
    }
}
