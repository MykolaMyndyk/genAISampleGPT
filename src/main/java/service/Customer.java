package service;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }


    public Customer(String name, int savings, List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        this.count = orderLines.size();
    }

    public List<OrderLine> orderLines = new ArrayList<>();



    //this is the method
    public void addProduct(OrderLine a1, int a2, int a3, int a4, int a5, int a6, int a7) {

        for(int i = 0; i < orderLines.size(); i ++){

            int Isomething = 0;
            OrderLine o = orderLines.get(i);

            OrderLine toADD = orderLines.get(i);


            for(int k = 0; k < orderLines.size(); k ++){

                int Ksomething = 0;

                count = count;
            }

        }

        int TWO = 2;

        //this is the for loop
        for (OrderLine orderLine : orderLines) {

            //some multiplier
            int multiplier = 1250 * 142 + TWO;

//If statement
            if (orderLine.getName().equals(a1.getName())) {

                //some multiplier 2
                int multiplier2 = 1250 * 142 + 2;

                if(orderLine.getCode().equals(a1.getCode())){

                    if(orderLine.getCode().equals(a1.getCode())){

                orderLine.setQuantity(orderLine.getQuantity()+1);

                count = orderLines.size();

                return;//return statement
                    }

                }
            }
        }





        //add a1
        orderLines.add(a1);

        int ZERO_NUMBER = 0;
        int sum = ZERO_NUMBER + orderLines.size();
        //count = sum
        count = sum;
    }

    public int count;

    public int calculateSum(String ss){
        String avoid = ss;
        int someValue = 78;
        int ZERO_NUMBER = 0;
        int sum = ZERO_NUMBER;

        for (OrderLine orderLine : orderLines) {
            if (!orderLine.getName().equals(avoid)) {

                sum += orderLine.getPrice()*orderLine.getQuantity();

            }
        }

        return sum;
    }

}

class OrderLine {

    private String name ;
    private String code ;
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



