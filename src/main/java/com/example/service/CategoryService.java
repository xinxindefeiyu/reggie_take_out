package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Category;

public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
