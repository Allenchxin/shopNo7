package com.shopno7.item.controller;

import com.shopno7.item.service.BrandService;
import com.shopno7.pojo.Brand;
import com.shopno7.pojo.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName BrandController
 * @Description 品牌查询controller
 * @Author Allen·Chen
 * @Date 2019/11/11 22:02
 * @Version 1.0
 */
@Controller
@RequestMapping("brand")
public class BrandController {

    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    /**
     * 根据页码查询页面数据
     *
     * @param page   页码数
     * @param rows   每页显示数
     * @param sortBy 是否排序
     * @param desc   倒序
     * @param key    排序关键字
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {

        PageResult<Brand> pageResult = brandService.queryBrandByPage(page, rows, sortBy, desc, key);
        if (null == pageResult || 0 == pageResult.getItems().size()) {//判断页面是否有数据
            logger.info("页面查询信息为空" + ",page:" + page + ",key:" + key);
            ResponseEntity.notFound().build();//404
        }
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 新增品牌
     * @param brand 品牌
     * @param cids 品牌对应的种类
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam(value = "cids") List<Long> cids) {
        brandService.saveBrand(brand,cids);
        ResponseEntity.status(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.CREATED); //服务器在请求的响应中建立了新文档

    }
}

