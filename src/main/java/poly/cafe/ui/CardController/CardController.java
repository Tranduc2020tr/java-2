/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.cafe.ui.CardController;

import java.util.List;
import poly.cafe.dao.CardDAO;
import poly.cafe.dao.impl.CardDAOImpl;
import poly.cafe.entity.Card;
import poly.cafe.ui.CrudController.CrudController;

/**
 *
 * @author hang
 */
public interface CardController extends CrudController<Card>{
     CardDAO dao = new CardDAOImpl();
    List<CardDAO> items = List.of();
}
