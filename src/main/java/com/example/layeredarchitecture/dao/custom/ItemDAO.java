package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.entity.Item;

public interface ItemDAO extends CrudDAO<Item> {
   /* public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException;
    public void deleteItem(String code) throws SQLException, ClassNotFoundException;
    public void saveItems(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;
    public void updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;
    public boolean updateItems(ItemDTO item) throws SQLException, ClassNotFoundException;
    public boolean exixtIds(String code) throws SQLException, ClassNotFoundException;
    public String generateIds () throws SQLException, ClassNotFoundException;
    public ItemDTO searchItems(String newItemCode) throws SQLException, ClassNotFoundException;*/
}
