package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PurchasedOrderBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class PurchasedOrderBOImpl implements PurchasedOrderBO {

    //I hava to implement the exists Item and Customer methods!!!!
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAPTypes.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAPTypes.ORDER_DETAIL);
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewId();
    }

    @Override
    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {
       return orderDAO.exist(orderId);
    }

    @Override
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.save(dto);
    }

    @Override
    public boolean save(OrderDetailDTO orderDetails) throws SQLException, ClassNotFoundException {
        return orderDetailDAO.save(orderDetails);
    }
}
