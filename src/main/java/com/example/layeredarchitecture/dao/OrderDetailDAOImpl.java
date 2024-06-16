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
    public boolean saveOrderDetails(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException {
        for (OrderDetailDTO orderDetailDTO : orderDetails){
            if (!saveOrderDetail(orderDetailDTO,orderId)){
                return false;
            }
        }
        return false;
    }
    @Override
    public boolean saveOrderDetail(OrderDetailDTO orderDetails ,String orderId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        pstm.setString(1, orderId);
        pstm.setString(2, orderDetails.getItemCode());
        pstm.setBigDecimal(3, orderDetails.getUnitPrice());
        pstm.setInt(4, orderDetails.getQty());
        return pstm.executeUpdate()>0;
    }
}
