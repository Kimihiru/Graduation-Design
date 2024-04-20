package org.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sakura
 * 管理员
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
}