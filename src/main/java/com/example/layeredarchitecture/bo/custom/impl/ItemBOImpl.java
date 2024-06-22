package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.ItemBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAPTypes.ITEM);

    public ArrayList<ItemDTO> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>() ;
        ArrayList<Item> items = itemDAO.loadAll();
        for (Item item : items){
            ItemDTO itemDTO = new ItemDTO(item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand());
            itemDTOS.add(itemDTO);
        }
        return itemDTOS;
    }

    public void delete(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Item item = new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
        return itemDAO.save(item);
    }

    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Item item = new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
        return itemDAO.update(item);
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public String generateNewId () throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }

    public ItemDTO searchAll(String newItemCode) throws SQLException, ClassNotFoundException {
        Item item = itemDAO.searchAll(newItemCode);
        ItemDTO itemDTO = new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
        return itemDTO;
    }
}
