/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui.CategoryController;

import java.util.List;
import poly.cafe.dao.CategoryDAO;
import poly.cafe.dao.impl.CategoryDAOImpl;
import poly.cafe.entity.Category;
import poly.cafe.ui.CrudController.CrudController;

/**
 *
 * @author hang
 */
public interface CategoryController extends CrudController<Category> {
    
    CategoryDAO dao = new CategoryDAOImpl();
    List<Category> items = List.of();

}
