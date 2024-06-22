package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PurchasedOrderBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;
import com.example.layeredarchitecture.entity.Order;
import com.example.layeredarchitecture.entity.OrderDetail;

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
        Order order = new Order(dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
        return orderDAO.save(order);
    }

    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        OrderDetail orderDetail = new OrderDetail(dto.getOid(),dto.getItemCode(),dto.getQty(),dto.getUnitPrice());
        return orderDetailDAO.save(orderDetail);
    }
}
