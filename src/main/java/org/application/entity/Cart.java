package org.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sakura
 * 景点预选表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    private Integer id;
    private String name;
    private String area;
}