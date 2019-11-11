package com.shopno7.item.service;

import com.shopno7.pojo.Category;
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
        category.setParentId(pid);
        return categoryMapper.select(category);
    }

    public void addCategoryListByParentId(Long pid, String name) {
        Category category = new Category();
        category.setParentId(pid);
        category.setName(name);
        category.setIsParent(true);
        categoryMapper.insert(category);
    }
}
