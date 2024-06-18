package com.example.layeredarchitecture.dao;

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
        String sql = "INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)";
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, orderDetails.getOid());
        pstm.setString(2, orderDetails.getItemCode());
        pstm.setBigDecimal(3, orderDetails.getUnitPrice());
        pstm.setInt(4, orderDetails.getQty());
        return pstm.executeUpdate()>0;
    }
}
