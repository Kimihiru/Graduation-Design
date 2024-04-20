package org.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sakura
 * 各区相隔距离
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Distance {
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