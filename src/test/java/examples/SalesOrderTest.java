package examples;

import category.SalesOrderTestCategory;
import org.example.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class SalesOrderTest {
    private  SalesOrder salesOrder ;
    private OrderItemService orderItemService;
    private OrderItem spyOi;
    private OrderItem oi1;
    private OrderItem oi2;
    private static final String ORDER_ITEM_NAME_1 = "OrderItem #1";
    private static final String ORDER_ITEM_NAME_2 = "OrderItem #2";
    private static final String ORDER_ITEM_ACTION_ADD = "Add";
    private static final String ORDER_ITEM_ACTION_MODIFY = "Modify";
    private static final int ORDER_ITEM_ID_1 = 1;
    private static final int ORDER_ITEM_ID_2 = 1;
    private static final int ORDER_ITEM_PRICE_1 = 50;
    private static final int ORDER_ITEM_DISCOUNT_PRICE = 70;
    private static final int ORDER_ITEM_PRICE_2 = 150;
    private static final int SALES_ORDER_PRICE = 200;


    @Before
    public void init() {
        salesOrder = new SalesOrder();
        orderItemService = mock(OrderItemService.class);
        salesOrder.setOrderItemService(orderItemService);
        List<OrderItem> orderItems = new ArrayList<>();
        oi1 = new OrderItem(ORDER_ITEM_ID_1, ORDER_ITEM_NAME_1, ORDER_ITEM_ACTION_ADD);
        oi2 = new OrderItem(ORDER_ITEM_ID_2, ORDER_ITEM_NAME_2, ORDER_ITEM_ACTION_ADD);
        orderItems.add(oi1);
        orderItems.add(oi2);
        salesOrder.setOrderItems(orderItems);
        when(orderItemService.getOrderItemPrice(oi1)).thenReturn(ORDER_ITEM_PRICE_1);
        when(orderItemService.getOrderItemPrice(oi2)).thenReturn(ORDER_ITEM_PRICE_2);
        spyOi = spy(oi1);
    }

    @Test
    @Category(SalesOrderTestCategory.class)
    public void verifyDiscountPrice(){
        orderItemService.getDiscountPrice(ORDER_ITEM_DISCOUNT_PRICE);
        Mockito.verify(orderItemService).getDiscountPrice(ORDER_ITEM_DISCOUNT_PRICE);
        Mockito.verify(orderItemService, times(1)).getDiscountPrice(ORDER_ITEM_DISCOUNT_PRICE);
    }

    @Test
    @Category(SalesOrderTestCategory.class)
    public void checkSalesOrderPrice() {
        int value = salesOrder.getSalesOrderPrice();
        assertEquals(SALES_ORDER_PRICE, value);
    }

    @Test
    @Category(SalesOrderTestCategory.class)
    public void verifyOrderItemSpyOnRealInstance(){
        spyOi.setAction(ORDER_ITEM_ACTION_MODIFY);
        assertNotEquals(spyOi.getAction(), oi1.getAction());
        assertEquals(ORDER_ITEM_ACTION_MODIFY, spyOi.getAction());
    }
}
