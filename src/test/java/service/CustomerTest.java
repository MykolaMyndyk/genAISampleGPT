package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        List<OrderLine> orderLines = new ArrayList<>();
        customer = new Customer("TestCustomer", 100, orderLines);
    }

    @Test
    public void testAddProduct_ValidProduct() {
        OrderLine productToAdd = new OrderLine();
        productToAdd.setName("Product1");
        productToAdd.setCode("123");
        productToAdd.setQuantity(1);
        productToAdd.setPrice(10);

        customer.addProduct(productToAdd, 0, 0, 0, 0, 0, 0);
        List<OrderLine> orderLines = customer.getOrderLines();

        assertEquals(1, orderLines.size());
        assertEquals("Product1", orderLines.get(0).getName());
        assertEquals("123", orderLines.get(0).getCode());
        assertEquals(1, orderLines.get(0).getQuantity());
        assertEquals(10, orderLines.get(0).getPrice());
    }

    @Test
    public void testAddProduct_ExistingProduct() {
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

        customer.addProduct(productToAdd, 0, 0, 0, 0, 0, 0);
        List<OrderLine> orderLines = customer.getOrderLines();

        assertEquals(1, orderLines.size());
        assertEquals(2, orderLines.get(0).getQuantity());
    }

    @Test
    public void testAddProduct_NegativeQuantity() {
        OrderLine productToAdd = new OrderLine();
        productToAdd.setName("Product1");
        productToAdd.setCode("123");
        productToAdd.setQuantity(-1);  // Negative quantity

        customer.addProduct(productToAdd, 0, 0, 0, 0, 0, 0);

        List<OrderLine> orderLines = customer.getOrderLines();
        assertEquals(0, orderLines.size());
    }

    @Test
    public void testAddProduct_InvalidCode() {
        OrderLine productToAdd = new OrderLine();
        productToAdd.setName("Product1");
        productToAdd.setCode("");  // Empty code
        productToAdd.setQuantity(1);
        productToAdd.setPrice(10);

        customer.addProduct(productToAdd, 0, 0, 0, 0, 0, 0);

        List<OrderLine> orderLines = customer.getOrderLines();
        assertEquals(0, orderLines.size());
    }

    @Test
    public void testAddProduct_EmptyName() {
        OrderLine productToAdd = new OrderLine();
        productToAdd.setName("");  // Empty name
        productToAdd.setCode("123");
        productToAdd.setQuantity(1);
        productToAdd.setPrice(10);

        customer.addProduct(productToAdd, 0, 0, 0, 0, 0, 0);

        List<OrderLine> orderLines = customer.getOrderLines();
        assertEquals(0, orderLines.size());
    }

    @Test
    public void testAddProduct_NullProduct() {
        customer.addProduct(null, 0, 0, 0, 0, 0, 0);
        List<OrderLine> orderLines = customer.getOrderLines();
        assertEquals(0, orderLines.size());
    }

    @Test
    public void testCalculateSum_NoMatchingProducts() {
        OrderLine product1 = new OrderLine();
        product1.setName("Product1");
        product1.setCode("123");
        product1.setQuantity(2);
        product1.setPrice(10);

        OrderLine product2 = new OrderLine();
        product2.setName("Product2");
        product2.setCode("456");
        product2.setQuantity(3);
        product2.setPrice(15);

        customer.getOrderLines().add(product1);
        customer.getOrderLines().add(product2);

        int sum = customer.calculateSum("NonExistentProduct");

        assertEquals(0, sum);
    }

    @Test
    public void testCalculateSum_MatchingProduct() {
        OrderLine product1 = new OrderLine();
        product1.setName("Product1");
        product1.setCode("123");
        product1.setQuantity(2);
        product1.setPrice(10);

        OrderLine product2 = new OrderLine();
        product2.setName("Product2");
        product2.setCode("456");
        product2.setQuantity(3);
        product2.setPrice(15);

        customer.getOrderLines().add(product1);
        customer.getOrderLines().add(product2);

        int sum = customer.calculateSum("Product1");

        assertEquals(20, sum);
    }

    @Test
    public void testAddProduct_NullName() {
        OrderLine productToAdd = new OrderLine();
        productToAdd.setName(null);  // Null name
        productToAdd.setCode("123");
        productToAdd.setQuantity(1);
        productToAdd.setPrice(10);

        customer.addProduct(productToAdd, 0, 0, 0, 0, 0, 0);
        List<OrderLine> orderLines = customer.getOrderLines();

        assertEquals(1, orderLines.size());
        assertNull(orderLines.get(0).getName());
    }

}