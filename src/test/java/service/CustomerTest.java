package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        List<OrderLine> orderLines = new ArrayList<>();
        customer = new Customer("TestCustomer", orderLines);
    }

    @Test
    public void testAddProduct_OneNewOrderLine() {
        OrderLine productToAdd = new OrderLine();
        productToAdd.setName("Product1");
        productToAdd.setCode("123");
        productToAdd.setQuantity(1);
        productToAdd.setPrice(10);

        customer.addProduct(productToAdd);
        List<OrderLine> orderLines = customer.getOrderLines();

        assertEquals(1, orderLines.size());
        assertEquals("Product1", orderLines.get(0).getName());
        assertEquals("123", orderLines.get(0).getCode());
        assertEquals(1, orderLines.get(0).getQuantity());
        assertEquals(10, orderLines.get(0).getPrice());
        assertEquals(1, customer.count);
    }

    @Test
    public void testAddProduct_MultipleNewOrderLines() {
        OrderLine product1 = new OrderLine();
        product1.setName("Product1");
        product1.setCode("123");
        product1.setQuantity(1);
        product1.setPrice(10);

        OrderLine product2 = new OrderLine();
        product2.setName("Product2");
        product2.setCode("456");
        product2.setQuantity(1);
        product2.setPrice(20);

        customer.addProduct(product1);
        customer.addProduct(product2);
        List<OrderLine> orderLines = customer.getOrderLines();

        assertEquals(2, orderLines.size());
        assertEquals("Product1", orderLines.get(0).getName());
        assertEquals("123", orderLines.get(0).getCode());
        assertEquals(1, orderLines.get(0).getQuantity());
        assertEquals(10, orderLines.get(0).getPrice());
        assertEquals("Product2", orderLines.get(1).getName());
        assertEquals("456", orderLines.get(1).getCode());
        assertEquals(1, orderLines.get(1).getQuantity());
        assertEquals(20, orderLines.get(1).getPrice());
        assertEquals(2, customer.count);
    }

    @Test
    public void testAddProduct_ExistingOrderLine() {
        OrderLine existingProduct = new OrderLine();
        existingProduct.setName("Product1");
        existingProduct.setCode("123");
        existingProduct.setQuantity(1);
        existingProduct.setPrice(10);

        customer.getOrderLines().add(existingProduct);

        OrderLine productToAdd = new OrderLine();
        productToAdd.setName("Product1");
        productToAdd.setCode("123");
        productToAdd.setQuantity(1);
        productToAdd.setPrice(10);

        customer.addProduct(productToAdd);
        List<OrderLine> orderLines = customer.getOrderLines();

        assertEquals(1, orderLines.size());
        assertEquals(2, orderLines.get(0).getQuantity());
        assertEquals(1, customer.count);
    }

    @Test
    public void testCountValueAfterAddingOrderLine() {
        OrderLine productToAdd = new OrderLine();
        productToAdd.setName("Product1");
        productToAdd.setCode("123");
        productToAdd.setQuantity(1);
        productToAdd.setPrice(10);

        customer.addProduct(productToAdd);

        assertEquals(1, customer.count);
    }

    @Test
    public void testCalculateSum_CalculatesPricesOfAllOrderLines() {
        OrderLine product1 = new OrderLine();
        product1.setName("Product1");
        product1.setCode("123");
        product1.setQuantity(2);
        product1.setPrice(10);

        OrderLine product2 = new OrderLine();
        product2.setName("Product2");
        product2.setCode("456");
        product2.setQuantity(3);
        product2.setPrice(20);

        customer.getOrderLines().add(product1);
        customer.getOrderLines().add(product2);

        int sum = customer.calculateSum("NotExistingProduct");

        // Calculation: (2 * 10) + (3 * 20) = 20 + 60 = 80
        assertEquals(80, sum);
    }

    @Test
    public void testCalculateSum_SkipOrderLinesWithMatchingName() {
        OrderLine product1 = new OrderLine();
        product1.setName("Product1");
        product1.setCode("123");
        product1.setQuantity(2);
        product1.setPrice(10);

        OrderLine product2 = new OrderLine();
        product2.setName("Product2");
        product2.setCode("456");
        product2.setQuantity(3);
        product2.setPrice(20);

        customer.getOrderLines().add(product1);
        customer.getOrderLines().add(product2);

        int sum = customer.calculateSum("Product1");

        // Calculation: Skip "Product1" because of name matching. Calculate only "Product2".
        assertEquals(60, sum);
    }

    @Test
    public void testCalculateSum_SkipOrderLinesWithMatchingNameAndPrice() {
        OrderLine product1 = new OrderLine();
        product1.setName("Product1");
        product1.setCode("123");
        product1.setQuantity(2);
        product1.setPrice(10);

        OrderLine product2 = new OrderLine();
        product2.setName("Product2");
        product2.setCode("456");
        product2.setQuantity(3);
        product2.setPrice(20);

        customer.getOrderLines().add(product1);
        customer.getOrderLines().add(product2);

        int sum = customer.calculateSum("Product1");

        // Calculation: Skip "Product1" because of name matching. Calculate only "Product2" with its price (3 * 20).
        assertEquals(60, sum);
    }
}