package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;

public interface PurchasedOrderBO extends SuperBO {

    public String generateNewId() throws SQLException, ClassNotFoundException;

    public boolean exist(String orderId) throws SQLException, ClassNotFoundException;

    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;

    public boolean save(OrderDetailDTO orderDetails ) throws SQLException, ClassNotFoundException;
}
