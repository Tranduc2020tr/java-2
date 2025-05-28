/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.ui;

import poly.cafe.entity.User;

/**
 *
 * @author hang
 */
public class XAuth {
    public static User user = User.builder()
    .username("tranduc")
    .password("123")
    .enabled(true)
    .manager(true)
    .fullname("Nguyễn Văn Tèo")
    .photo("C:\\Users\\hang\\Documents\\NetBeansProjects\\PoLyCaFe\\src\\main\\resources\\trump-small.png")
    .build(); // biến user này sẽ được thay thế sau khi đăng nhập
   }

