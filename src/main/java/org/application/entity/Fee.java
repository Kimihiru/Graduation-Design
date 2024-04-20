package org.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sakura
 * 经过各区费用
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fee {
    private String area;
    private Integer panyu;
    private Integer nansha;
    private Integer liwan;
    private Integer yuexiu;
    private Integer haizhu;
    private Integer tianhe;
    private Integer baiyun;
    private Integer huangpu;
    private Integer huadu;
    private Integer zengcheng;
    private Integer conghua;
}