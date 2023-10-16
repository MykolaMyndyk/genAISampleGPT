package service;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<OrderLine> orderLines = new ArrayList<>();
    public int count;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Customer(String name, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        updateCount();
    }

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

    public int calculateSum(String avoidName) {
        int sum = 0;
        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(avoidName)) {
                sum += orderLine.getPrice() * orderLine.getQuantity();
            }
        }
        return sum;
    }

    private void updateCount() {
        count = orderLines.size();
    }
}

class OrderLine {
    private String name;
    private String code;
    private int quantity;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}