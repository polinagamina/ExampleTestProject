import org.example.OrderItem;
import org.example.OrderItemService;
import org.example.SalesOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalesOrderTest {
    SalesOrder salesOrder;
    OrderItemService orderItemService;
    @Before
    public void init() {
        salesOrder = new SalesOrder();
        orderItemService = mock(OrderItemService.class);
        salesOrder.setOrderItemService(orderItemService);
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem oi1 = new OrderItem(1, "OrderItem #1", "Add");
        OrderItem oi2 = new OrderItem(2, "OrderItem #2", "Add");
        orderItems.add(oi1);
        orderItems.add(oi2);
        salesOrder.setOrderItems(orderItems);
        when(orderItemService.getOrderItemPrice(oi1)).thenReturn(50);
        when(orderItemService.getOrderItemPrice(oi2)).thenReturn(150);
    }

    @Test
    public void checkSalesOrderPrice() {
        int value = salesOrder.getSalesOrderPrice();
        assertEquals(200, value);
    }
}
