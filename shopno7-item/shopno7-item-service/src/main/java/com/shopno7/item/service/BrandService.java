package com.shopno7.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shopno7.item.mapper.BrandMapper;
import com.shopno7.pojo.Brand;
import com.shopno7.pojo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName BrandService
 * @Description TODO
 * @Author Allen·Chen
 * @Date 2019/11/11 22:20
 * @Version 1.0
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //开始分页
        PageHelper.startPage(page, rows);
        // 过滤数据
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) { // 判断关键字是否为空
            example.createCriteria().andLike("name", "%" + key + "key").orEqualTo("letter", key);
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            // 升序或降序
            String orderBySort = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderBySort);
        }
        // 获取结果
        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);
        // 获取前端的数据：总数据和页面信息
        PageResult<Brand> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo);
        return pageResult;
    }

    /**
     * 既要插入品牌数据也要维护商品分类和品牌的关联表
     *
     * @param brand
     * @param cids
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        // 新增品牌
        brandMapper.insertSelective(brand);
        // 关联表添加数据
        cids.forEach(cid -> {
            brandMapper.insertCategoryBrand(cid, brand.getId());
        });
    }
}
