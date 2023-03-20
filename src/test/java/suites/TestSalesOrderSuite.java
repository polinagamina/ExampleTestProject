package suites;

import category.SalesOrderTestCategory;
import examples.SalesOrderTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class) @Categories.IncludeCategory(SalesOrderTestCategory.class)
@Suite.SuiteClasses({ SalesOrderTest.class})
public class TestSalesOrderSuite {

}
