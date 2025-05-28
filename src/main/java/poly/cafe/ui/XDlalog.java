/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.ui;

import javax.swing.JOptionPane;

/**
 *
 * @author hang
 */
public class XDlalog {
    
    public static void alert(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

   
    public static void alert(String message) {
        alert(message, "Thông báo");
    }

  
    public static boolean confirm(String message, String title) {
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return option == JOptionPane.YES_OPTION;
    }

 
    public static boolean confirm(String message) {
        return confirm(message, "Xác nhận");
    }

   
    public static String prompt(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }

   
    public static String prompt(String message) {
        return prompt(message, "Nhập vào");
    }
}
