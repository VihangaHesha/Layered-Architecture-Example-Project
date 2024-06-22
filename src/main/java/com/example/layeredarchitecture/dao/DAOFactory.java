package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    //singleton

    private DAOFactory(){

    }
    //enum
    public enum DAPTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL,QUERY
    }

    public SuperDAO getDao(DAPTypes dapTypes){
        switch (dapTypes){

            case CUSTOMER:
                return new CustomerDAOImpl();

            case ITEM:
                return new ItemDAOImpl();

            case ORDER:
                return new OrderDAOImpl();

            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();

            case QUERY:
                return new QueryDAOImpl();

            default:
                return null;

        }
    }

    //method(enum)
    //CustomerDAOImpl,ItemDAOImpl,OrderDAoImpl,OrderDetailDAOImpl
    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
}
