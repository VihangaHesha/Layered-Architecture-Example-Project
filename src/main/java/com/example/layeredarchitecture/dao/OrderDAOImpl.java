package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public class OrderDAOImpl implements OrderDAO{
    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace(
                "OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public void existOrder(String orderId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        pstm.setString(1,orderId);
        pstm.executeQuery().next();

    }
    @Override
    public PreparedStatement saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pst = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        pst.setString(1,orderId);
        pst.setDate(2, Date.valueOf(orderDate));
        pst.setString(3,customerId);
        return pst;
    }
}
