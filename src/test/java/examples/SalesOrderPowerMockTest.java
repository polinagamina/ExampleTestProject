package examples;

import category.SalesOrderTestCategory;
import org.example.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DiscountService.class, OfferService.class })
@Category(SalesOrderTestCategory.class)
public class SalesOrderPowerMockTest {
    DiscountService discountService;
    private final int TEST_VALUE1 = 170;
    private final int TEST_VALUE2 = 140;
    private final double RESULT_VALUE1 = 25.5;
    private final double RESULT_VALUE2 = 7.0;
    private final int DELTA = 0;
    private final String MOBILE_PREPAID = "Mobile Prepaid";
    private final String RESULT_OFFER_NAME_STRING = "Offer Mobile Prepaid";
    @Before
    public void init() {
        discountService = PowerMockito.mock(DiscountService.class);
        PowerMockito.mockStatic(OfferService.class);
        Mockito.when(discountService.createDiscount(TEST_VALUE1)).thenReturn(RESULT_VALUE1);
        Mockito.when(discountService.createDiscount(TEST_VALUE2)).thenReturn(RESULT_VALUE2);
        Mockito.when(OfferService.addOfferToName(MOBILE_PREPAID)).thenReturn(RESULT_OFFER_NAME_STRING);
    }

    @Test

    public void checkCreateDiscountReturnValue() {
        Assert.assertEquals(discountService.createDiscount(TEST_VALUE1), RESULT_VALUE1,DELTA);
        Mockito.verify(discountService).createDiscount (TEST_VALUE1);
        Assert.assertEquals(discountService.createDiscount(TEST_VALUE2), RESULT_VALUE2,DELTA);
        Mockito.verify(discountService).createDiscount (TEST_VALUE2);
    }
    @Test
    public void mockStaticClassTest() {
        Assert.assertEquals(OfferService.addOfferToName(MOBILE_PREPAID), RESULT_OFFER_NAME_STRING);
    }
}
