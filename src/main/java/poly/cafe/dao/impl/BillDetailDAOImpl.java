package poly.cafe.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.cafe.dao.BillDetailDAO;
import poly.cafe.entity.BillDetail;
import poly.cafe.util.XJdbc;

public class BillDetailDAOImpl implements BillDetailDAO {

    String createSql = "INSERT INTO BillDetails (BillId, DrinkId, UnitPrice, Discount, Quantity) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE BillDetails SET BillId = ?, DrinkId = ?, UnitPrice = ?, Discount = ?, Quantity = ? WHERE Id = ?";
    String deleteSql = "DELETE FROM BillDetails WHERE Id = ?";
    String findAllSql = "SELECT * FROM BillDetails";
    String findByIdSql = "SELECT * FROM BillDetails WHERE Id = ?";
    String findByBillIdSql = "SELECT * FROM BillDetails WHERE BillId = ?";
    String findByDrinkIdSql = "SELECT * FROM BillDetails WHERE DrinkId = ?";

    @Override
    public BillDetail create(BillDetail entity) {
        XJdbc.executeUpdate(createSql,
            entity.getBillId(),
            entity.getDrinkId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity()
        );
        return entity;
    }

    @Override
    public void update(BillDetail entity) {
        XJdbc.executeUpdate(updateSql,
            entity.getBillId(),
            entity.getDrinkId(),
            entity.getUnitPrice(),
            entity.getDiscount(),
            entity.getQuantity(),
            entity.getId()
        );
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<BillDetail> findAll() {
        return selectBySql(findAllSql);
    }

    @Override
    public BillDetail findById(Long id) {
        List<BillDetail> list = selectBySql(findByIdSql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<BillDetail> findByBillId(Long billId) {
        return selectBySql(findByBillIdSql, billId);
    }

    @Override
    public List<BillDetail> findByDrinkId(String drinkId) {
        return selectBySql(findByDrinkIdSql, drinkId);
    }

    private List<BillDetail> selectBySql(String sql, Object... args) {
        List<BillDetail> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                BillDetail bd = new BillDetail();
                bd.setId(rs.getLong("Id"));
                bd.setBillId(rs.getLong("BillId"));
                bd.setDrinkId(rs.getString("DrinkId"));
                bd.setUnitPrice(rs.getDouble("UnitPrice"));
                bd.setDiscount(rs.getDouble("Discount"));
                bd.setQuantity(rs.getInt("Quantity"));
                list.add(bd);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
