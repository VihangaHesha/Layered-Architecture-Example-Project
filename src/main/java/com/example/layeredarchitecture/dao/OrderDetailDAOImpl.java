package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.Util.SQLUtil;
import com.example.layeredarchitecture.controller.PlaceOrderFormController;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO  {
    @Override
    public boolean saveOrderDetail(OrderDetailDTO orderDetails ) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderDetails.getOid(),
                orderDetails.getItemCode(),
                orderDetails.getUnitPrice(),
                orderDetails.getQty());
    }
}
