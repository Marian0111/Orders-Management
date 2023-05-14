package org.example.start;
import org.example.presentation.*;

public class Start {
    public static void main(String[] args){

        ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        OrderView orderView  = new OrderView();
        new Controller(clientView, productView, orderView);

    }
}
