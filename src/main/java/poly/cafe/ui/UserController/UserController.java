/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui.UserController;

import java.util.List;
import poly.cafe.dao.UserDAO;
import poly.cafe.dao.impl.UserDAOImpl;
import poly.cafe.entity.User;
import poly.cafe.ui.CrudController.CrudController;

/**
 *
 * @author hang
 */
public interface UserController extends CrudController<User> {
    UserDAO dao = new UserDAOImpl();
    List<UserDAO> items = List.of();
}
