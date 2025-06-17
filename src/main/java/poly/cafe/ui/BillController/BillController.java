/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui.BillController;

import poly.cafe.entity.Bill;
import poly.cafe.ui.CrudController.CrudController;

/**
 *
 * @author hang
 */
public interface BillController extends CrudController<Bill> {

    void fillBillDetails();

    void selectTimeRange();

    void setBill(Bill bill); // truyền bill vào cửa sổ để hiển thị

    void open(); // Hiển thị bill

    void close(); // Xóa bill nếu ko chứa đồ uống nào

    void showDrinkJDialog(); // Hiển thị cửa sổ bổ sung đồ uống vào bill

    void removeDrinks();

    void updateQuantity(); // Thay đổi số lượng đồ uống

    void checkout(); // Thanh toán

    void cancel();
}
