package org.example;

public interface OrderItemService {
    public int getOrderItemPrice(OrderItem orderItem);
    public int getDiscountPrice(int price);
}
