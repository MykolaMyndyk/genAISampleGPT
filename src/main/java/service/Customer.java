package service;

import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class represents a customer and their list of order lines.
 */
public class Customer {
    private List<OrderLine> orderLines = new ArrayList<>();
    public int count;

    /**
     * Get the list of order lines associated with the customer.
     *
     * @return The list of order lines.
     */
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Creates a new customer with a given name and list of order lines.
     *
     * @param name       The name of the customer.
     * @param orderLines The list of order lines associated with the customer.
     */
    public Customer(String name, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        updateCount();
    }

    /**
     * Adds a product to the customer's order lines. If a product with the same name and code
     * already exists, its quantity is incremented.
     *
     * @param product The product to be added.
     */
    public void addProduct(OrderLine product) {
        if (product != null) {
            for (OrderLine existingProduct : orderLines) {
                if (existingProduct.getName().equals(product.getName()) &&
                        existingProduct.getCode().equals(product.getCode())) {
                    existingProduct.setQuantity(existingProduct.getQuantity() + 1);
                    updateCount();
                    return;
                }
            }
            orderLines.add(product);
            updateCount();
        }
    }

    /**
     * Calculates the sum of prices for order lines, excluding those with a specified name.
     *
     * @param avoidName The name of order lines to exclude from the sum.
     * @return The calculated sum of prices.
     */
    public int calculateSum(String avoidName) {
        int sum = 0;
        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(avoidName)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }
        return sum;
    }

    /**
     * Updates the count of order lines associated with the customer.
     */
    private void updateCount() {
        count = orderLines.size();
    }
}

class OrderLine {
    private String name;
    private String code;
    private int quantity;
    private int price;

    /**
     * Get the name of the order line.
     *
     * @return The name of the order line.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the order line.
     *
     * @param name The name to set for the order line.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the quantity of the order line.
     *
     * @return The quantity of the order line.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the order line.
     *
     * @param quantity The quantity to set for the order line.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the price of the order line.
     *
     * @return The price of the order line.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price of the order line.
     *
     * @param price The price to set for the order line.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get the code of the order line.
     *
     * @return The code of the order line.
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the code of the order line.
     *
     * @param code The code to set for the order line.
     */
    public void setCode(String code) {
        this.code = code;
    }
}