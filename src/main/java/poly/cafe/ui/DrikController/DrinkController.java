/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui.DrikController;

import java.util.List;
import poly.cafe.dao.DrinkDAO;
import poly.cafe.dao.impl.DrinkDAOImpl;
import poly.cafe.entity.Bill;
import poly.cafe.entity.Drink;
import poly.cafe.ui.CrudController.CrudController;

/**
 *
 * @author hang
 */
public interface DrinkController extends CrudController<Drink> {
    DrinkDAO dao = new DrinkDAOImpl();  
    List<Drink> items = List.of();      
    void fillCategories();
    void chooseFile();
    void setBill(Bill bill); // nhận bill từ BillJDialog
    void fillDrinks(); // tải và hiển thị đồ uống
    void addDrinkToBill(); // thêm đồ uống vào bil
}
