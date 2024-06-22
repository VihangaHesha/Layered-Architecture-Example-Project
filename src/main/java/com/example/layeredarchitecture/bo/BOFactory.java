package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.custom.impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.custom.impl.PurchasedOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }

    public enum BOType{
        CUSTOMER,ITEM,PURCHASED
    }

    public SuperBO getBo(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PURCHASED:
                return new PurchasedOrderBOImpl();
            default:
                return null;
        }
    }

    public static BOFactory getBoFactory(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }
}
