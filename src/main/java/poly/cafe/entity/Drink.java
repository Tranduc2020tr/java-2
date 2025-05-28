/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.entity;

import lombok.*;

/**
 *
 * @author hang
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Drink {
 private String id;
 private String name;
 private String image;
 private double unitPrice;
 private double discount;
 private boolean available;
 private String categoryId;
}
