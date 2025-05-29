package poly.cafe.dao.impl;

import poly.cafe.dao.CardDAO;
import poly.cafe.util.XJdbc;
import poly.cafe.util.XQuery;
import poly.cafe.entity.Card;


import java.util.List;

public class CardDAOImpl implements CardDAO {

    String createSql = "INSERT INTO Cards(Id, Status) VALUES (?, ?)";
    String updateSql = "UPDATE Cards SET Status = ? WHERE Id = ?";
    String deleteSql = "DELETE FROM Cards WHERE Id = ?";
    String findAllSql = "SELECT * FROM Cards";
    String findByIdSql = "SELECT * FROM Cards WHERE Id = ?";

    @Override
    public Card create(Card entity) {
         Card existing = findById(entity.getId());
    if (existing != null) {
        throw new RuntimeException("ID đã tồn tại. Vui lòng chọn ID khác.");
    }
       Object[] values = {
            entity.getId(),
            entity.getStatus()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Card entity) {
        XJdbc.update(updateSql, entity.getStatus(), entity.getId());
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.update(deleteSql, id);
    }

    @Override
    public List<Card> findAll() {
        return XQuery.getBeanList(Card.class, findAllSql);
    }

    @Override
    public Card findById(Integer id) {
        return XQuery.getSingleBean(Card.class, findByIdSql, id);
    }
    
}