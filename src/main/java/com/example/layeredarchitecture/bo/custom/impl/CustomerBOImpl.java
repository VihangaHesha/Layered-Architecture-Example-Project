package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAPTypes.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {
       ArrayList<Customer> customer = customerDAO.loadAll();
       ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
       for (Customer customerList : customer){
        CustomerDTO customerDTO = new CustomerDTO(customerList.getId(),
                customerList.getName(),
                customerList.getAddress());
        customerDTOS.add(customerDTO);
       }
       return customerDTOS;
    }
    @Override
    public boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        Customer customer = new Customer(dto.getId(),dto.getName(),dto.getAddress());
        return customerDAO.save(customer);
    }
    @Override
    public boolean updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        Customer customer = new Customer(dto.getId(),dto.getName(),dto.getAddress());
        return customerDAO.update(customer);
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
        Customer customer = customerDAO.searchAll(newValue);
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
        return customerDTO;
    }
}
