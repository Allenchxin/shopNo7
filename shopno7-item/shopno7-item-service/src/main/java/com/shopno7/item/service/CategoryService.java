package com.shopno7.item.service;

import com.shopno7.item.Category;
import com.shopno7.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author Allen·Chen
 * @Date 2019/11/8 22:52
 * @Version 1.0
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByParentId(Long pid) {
        Category category = new Category();
        category.setId(pid);
        return categoryMapper.select(category);
    }
}
