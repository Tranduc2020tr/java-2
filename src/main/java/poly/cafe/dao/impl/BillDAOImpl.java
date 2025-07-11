package poly.cafe.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import poly.cafe.dao.BillDAO;
import poly.cafe.entity.Bill;
import poly.cafe.ui.XAuth;
import poly.cafe.util.XJdbc;
import poly.cafe.util.XQuery;

public class BillDAOImpl implements BillDAO {
    String createSql = "INSERT INTO Bills (Username, CardId, Checkin, Checkout, Status) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Bills SET Username=?, CardId=?, Checkin=?, Checkout=?, Status=? WHERE Id=?";
    String deleteSql = "DELETE FROM Bills WHERE Id=?";
    String findAllSql = "SELECT * FROM Bills";
    String findByIdSql = "SELECT * FROM Bills WHERE Id=?";
    String findByUsernameSql = "SELECT * FROM Bills WHERE Username=?";
    String findByCardIdSql = "SELECT * FROM Bills WHERE CardId=?";
     String findByTimeRangeSql = "SELECT * FROM Bills WHERE Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";

    @Override
    public Bill create(Bill entity) {
        String sql = "INSERT INTO Bills (Username, CardId, Checkin, Checkout, Status) VALUES (?, ?, ?, ?, ?)";
        try {
            Long id = XJdbc.executeInsert(sql,
                entity.getUsername(),
                entity.getCardId(),
                entity.getCheckin(),
                entity.getCheckout(),
                entity.getStatus()
            );
            entity.setId(id);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi tạo hóa đơn mới", e);
        }
    }

    @Override
    public void update(Bill entity) {
        XJdbc.executeUpdate(updateSql,
            entity.getUsername(),
            entity.getCardId(),
            entity.getCheckin(),
            entity.getCheckout(),
            entity.getStatus(),
            entity.getId()
        );
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<Bill> findAll() {
        return selectBySql(findAllSql);
    }

    @Override
    public Bill findById(Long id) {
        List<Bill> list = selectBySql(findByIdSql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Bill> findByUsername(String username) {
        return selectBySql(findByUsernameSql, username);
    }

    @Override
    public List<Bill> findByCardId(Integer cardId) {
        return selectBySql(findByCardIdSql, cardId);
    }

    private List<Bill> selectBySql(String sql, Object... args) {
        List<Bill> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Bill b = new Bill();
                b.setId(rs.getLong("Id"));
                b.setUsername(rs.getString("Username"));
                b.setCardId(rs.getInt("CardId"));
                b.setCheckin(rs.getTimestamp("Checkin"));
                b.setCheckout(rs.getTimestamp("Checkout"));
                b.setStatus(rs.getInt("Status"));
                list.add(b);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException("lỗi bill em ơi", e);
        }
        return list;
    }

    @Override
    public List<Bill> findByTimeRange(Date begin, Date end) {
        return selectBySql(findByTimeRangeSql, begin, end);
    }

    @Override
    public Bill findServicingByCardId(Integer cardId) {
        String sql = "SELECT * FROM Bills WHERE CardId=? AND Status=0";
        Bill bill = XQuery.getSingleBean(Bill.class, sql, cardId);
        if (bill == null) { 
            Bill newBill = new Bill();
            newBill.setCardId(cardId);
            newBill.setCheckin(new Date());
            newBill.setStatus(0); 
            newBill.setUsername(XAuth.user.getUsername());
            bill = this.create(newBill); 
        }
        return bill;
    }

    @Override
    public List<Bill> findByUserAndTimeRange(String username, Date begin, Date end) {

        String sql = "SELECT * FROM Bills "
                + " WHERE Username=? AND Checkin BETWEEN ? AND ?";
        return XQuery.getBeanList(Bill.class, sql, username, begin, end);
    }

}

