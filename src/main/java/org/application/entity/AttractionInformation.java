package org.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sakura
 * 景点信息
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttractionInformation {
    private Integer id;
    private String name;
    private String opentime;
    private String line;
    private String price;
    private String address;
    private String type;
    private String hot;
    private String telephone;
    private String score;
    private String area;
    private String food;
}