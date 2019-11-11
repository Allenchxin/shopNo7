package com.shopno7.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Brand
 * @Description 品牌
 * @Author Allen·Chen
 * @Date 2019/11/11 21:50
 * @Version 1.0
 */
@Table(name = "tb_brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增长策略
    private Long id;
    private String name;//品牌名称
    private String image;//品牌图片
    private Character letter;//品牌首字母    单字符操作

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }
}
