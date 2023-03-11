package org.example;

import java.util.List;

public class SalesOrder {
    private OrderItemService orderItemService;
    private List<OrderItem> orderItems;

    public OrderItemService getOrderItemService() {
        return orderItemService;
    }

    public void setOrderItemService(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public int getSalesOrderPrice(){
        int value = 0;

        for(OrderItem orderItem : orderItems){
            value += orderItemService.getOrderItemPrice(orderItem);
        }
        return value;
    }
}
