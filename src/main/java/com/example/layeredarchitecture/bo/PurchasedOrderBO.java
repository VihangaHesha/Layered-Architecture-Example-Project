package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PurchasedOrderBO {

    public String generateNewId() throws SQLException, ClassNotFoundException;

    public boolean exist(String orderId) throws SQLException, ClassNotFoundException;

    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException;

    public boolean save(OrderDetailDTO orderDetails ) throws SQLException, ClassNotFoundException;
}
