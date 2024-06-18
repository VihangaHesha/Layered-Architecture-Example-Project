package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.Util.SQLUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO{
    @Override
    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
    @Override
    public boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException {

        CustomerDTO customerDTO = new CustomerDTO(id,name,address);
        String sql = "INSERT INTO Customer (id,name, address) VALUES (?,?,?)";
        return SQLUtil.execute(sql,customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }
    @Override
    public void updateCustomer(String id,String name,String address) throws SQLException, ClassNotFoundException {
        CustomerDTO customerDTO = new CustomerDTO(id,name,address);
        SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress() );
    }
    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {

        SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        return rst.next();
    }
    @Override
    public CustomerDTO searchAllCustomers(String newValue) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue);
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
        return customerDTO;
    }
}
