package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {

    public ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException ;

    public void delete(String code) throws SQLException, ClassNotFoundException;

    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean exist(String code) throws SQLException, ClassNotFoundException;

    public String generateNewId () throws SQLException, ClassNotFoundException ;

    public ItemDTO searchAll(String newItemCode) throws SQLException, ClassNotFoundException;
}
