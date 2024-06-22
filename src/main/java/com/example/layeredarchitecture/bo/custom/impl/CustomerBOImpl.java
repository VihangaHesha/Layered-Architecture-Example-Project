package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAPTypes.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.loadAll();
    }
    @Override
    public boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(dto);
    }
    @Override
    public boolean updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }
    @Override
    public void deleteCustomers(String id) throws SQLException, ClassNotFoundException {

        customerDAO.delete(id);
    }
    @Override
    public String generateNewCustomersId() throws SQLException, ClassNotFoundException {
       return customerDAO.generateNewId();
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
    @Override
    public CustomerDTO searchAllCustomers(String newValue) throws SQLException, ClassNotFoundException {

        return customerDAO.searchAll(newValue);
    }
}
