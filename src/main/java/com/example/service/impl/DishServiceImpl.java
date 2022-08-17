package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Dish;
import com.example.mapper.DishMapper;
import com.example.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    public static interface DishService extends IService<Dish> {

    }
}
