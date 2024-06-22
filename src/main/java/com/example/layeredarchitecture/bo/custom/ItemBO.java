package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

    public ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException ;

    public void delete(String code) throws SQLException, ClassNotFoundException;

    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean exist(String code) throws SQLException, ClassNotFoundException;

    public String generateNewId () throws SQLException, ClassNotFoundException ;

    public ItemDTO searchAll(String newItemCode) throws SQLException, ClassNotFoundException;
}
