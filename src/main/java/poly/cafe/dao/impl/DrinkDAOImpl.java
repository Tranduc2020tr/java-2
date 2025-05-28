package poly.cafe.dao.impl;

import java.util.List;
import poly.cafe.dao.DrinkDAO;
import poly.cafe.entity.Drink;
import poly.cafe.util.XJdbc;
import poly.cafe.util.XQuery;

public class DrinkDAOImpl implements DrinkDAO {

    // Câu lệnh SQL
    String createSql = "INSERT INTO Drinks (Id, Name, UnitPrice, Discount, Image, Available, CategoryId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Drinks SET Name=?, UnitPrice=?, Discount=?, Image=?, Available=?, CategoryId=? WHERE Id=?";
    String deleteSql = "DELETE FROM Drinks WHERE Id=?";
    String findAllSql = "SELECT * FROM Drinks";
    String findByIdSql = "SELECT * FROM Drinks WHERE Id=?";
    String findByCategoryIdSql = "SELECT * FROM Drinks WHERE CategoryId=?";

    @Override
    public Drink create(Drink entity) {
        XJdbc.update(createSql,
            entity.getId(),
            entity.getName(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getImage(),
            entity.isAvailable(),
            entity.getCategoryId()
        );
        return entity;
    }

    @Override
    public void update(Drink entity) {
        XJdbc.update(updateSql,
            entity.getName(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getImage(),
            entity.isAvailable(),
            entity.getCategoryId(),
            entity.getId()
        );
    }

    @Override
    public void deleteById(String id) {
        XJdbc.update(deleteSql, id);
    }

    @Override
    public List<Drink> findAll() {
        return XQuery.getBeanList(Drink.class, findAllSql);
    }

    @Override
    public Drink findById(String id) {
        return XQuery.getSingleBean(Drink.class, findByIdSql, id);
    }

    @Override
    public List<Drink> findByCategoryId(String categoryId) {
        return XQuery.getBeanList(Drink.class, findByCategoryIdSql, categoryId);
    }
}