package com.shopno7.item.controller;

import com.shopno7.item.Category;
import com.shopno7.item.service.CategoryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author Allen·Chen
 * @Date 2019/11/8 22:41
 * @Version 1.0
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据id查询商品分类
     *
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByParentId(@RequestParam(value = "pid", defaultValue = "0") Long pid) {

        try {
            if (pid == null || pid.longValue() < 0) {//如果请求参数为0，返回错误请求
                logger.info("请求参数为空======>" + pid);
                return ResponseEntity.badRequest().build();
            }
            List<Category> categories = categoryService.queryCategoryListByParentId(pid);
            if (CollectionUtils.isEmpty(categories)) {
                logger.info("查询商品分类为空");
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            logger.error("查询商品分类出现异常", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
