/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui.CrudController;

/**
 *
 * @author hang
 */
public interface CrudController<Entity> {
    void open(); // Xử lý mở cửa sổ CRUDCONTROLLER
    void setForm(Entity entity); // Hiển thị thực thể lên form
    Entity getForm(); // Tạo thực thể từ dữ liệu form
    void fillToTable(); // Tải dữ liệu và đổ lên bảng
    void edit(); // Hiển thị dữ liệu của hàng được chọn lên
    
    void create(); // Tạo thực thể mới
    void update(); // Cập nhật thực thể đang xem
    void delete(); // Xóa thực thể đang xem
    void clear(); // Xóa trắng form
    void setEditable(boolean editable); // Thay đổi trạng thái
    
    void checkAll(); // Tích chọn tất cả các hàng trên bảng
    void uncheckAll(); // Bỏ tích chọn tất cả các hàng trên
    
    void deleteCheckedItems(); // Xóa các thực thể được tích
    
    void moveFirst(); // Hiển thị thực thể đầu tiên
    void movePrevious(); // Hiển thị thực thể kế trước
    void moveNext(); // Hiển thị thực thể kế sau
    void moveLast(); 
    void moveTo(int index);
}
