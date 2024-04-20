package org.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sakura
 * 用户信息表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}