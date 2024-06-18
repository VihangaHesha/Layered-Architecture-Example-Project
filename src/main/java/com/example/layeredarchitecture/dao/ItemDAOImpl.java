package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.Util.SQLUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO{
    @Override
    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");

        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
                    );
            itemDTOS.add(itemDTO);
        }
        return itemDTOS;
    }
    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {

        SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public void saveItems(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {

        ItemDTO itemDTO = new ItemDTO(code,description,unitPrice,qtyOnHand);

        SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
                itemDTO.getCode(),itemDTO.getDescription(),
                itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
    @Override
    public void updateItem(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException {
        ItemDTO itemDTO = new ItemDTO(code,description,unitPrice,qtyOnHand);

        SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                itemDTO.getDescription(),
                itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
    }
    @Override
    public boolean updateItems(ItemDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                dto.getDescription(),dto.getQtyOnHand(),dto.getUnitPrice(),dto.getCode());
    }
    @Override
    public boolean exixtIds(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
        return rst.next();
    }
    @Override
    public String generateIds () throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

       if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
    @Override
    public ItemDTO searchItems(String newItemCode) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?", newItemCode);
        rst.next();
        ItemDTO itemDTO = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return itemDTO;
    }
}
