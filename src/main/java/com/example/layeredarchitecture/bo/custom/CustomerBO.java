package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException;

    public boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    public void deleteCustomers(String id) throws SQLException, ClassNotFoundException;

    public String generateNewCustomersId() throws SQLException, ClassNotFoundException ;

    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public CustomerDTO searchAllCustomers(String newValue) throws SQLException, ClassNotFoundException ;
}
