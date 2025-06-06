package poly.cafe.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.cafe.dao.BillDetailDAO;
import poly.cafe.entity.BillDetail;
import poly.cafe.util.XJdbc;

public class BillDetailDAOImpl implements BillDetailDAO {

    private final String createSql = "INSERT INTO BillDetails (BillId, DrinkId, UnitPrice, Discount, Quantity) VALUES (?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE BillDetails SET BillId = ?, DrinkId = ?, UnitPrice = ?, Discount = ?, Quantity = ? WHERE Id = ?";
    private final String deleteSql = "DELETE FROM BillDetails WHERE Id = ?";

    // Tất cả SELECT đều JOIN với Drinks để có DrinkName
    private final String baseSelectSql = """
        SELECT bd.*, d.Name AS DrinkName 
        FROM BillDetails bd 
        JOIN Drinks d ON bd.DrinkId = d.Id
    """;
    private final String findAllSql = baseSelectSql;
    private final String findByIdSql = baseSelectSql + " WHERE bd.Id = ?";
    private final String findByBillIdSql = baseSelectSql + " WHERE bd.BillId = ?";
    private final String findByDrinkIdSql = baseSelectSql + " WHERE bd.DrinkId = ?";

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
                bd.setDrinkName(rs.getString("DrinkName")); // Không cần try-catch nữa

                list.add(bd);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            System.err.println("❌ Lỗi khi thực thi SQL: " + sql);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
}
