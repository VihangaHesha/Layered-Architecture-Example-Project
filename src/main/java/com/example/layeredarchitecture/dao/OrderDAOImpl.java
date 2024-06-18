package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.Util.SQLUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;

public class OrderDAOImpl implements OrderDAO{
    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace(
                "OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return rst.next();

    }
    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)"
                ,dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
    }
}
