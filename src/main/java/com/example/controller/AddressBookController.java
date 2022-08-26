package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.BaseContext;
import com.example.common.R;
import com.example.entity.AddressBook;
import com.example.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;

    @PostMapping
    public R<String> save(@RequestBody AddressBook addressBook, HttpSession session) {
        Long userId = (Long) session.getAttribute("user");
        addressBook.setUserId(userId);
        addressBookService.save(addressBook);
        return R.success("保存成功");
    }

    @GetMapping("/list")
    public R<List<AddressBook>> list() {
        List<AddressBook> addressBooks = addressBookService.list();
        return R.success(addressBooks);
    }

    @PutMapping("/default")
    public R<AddressBook> defaultAddress(@RequestBody AddressBook addressBook, HttpSession session) {
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
        queryWrapper.eq(AddressBook::getIsDefault, 1);
        AddressBook addressBook1 = addressBookService.getOne(queryWrapper);
        addressBook1.setIsDefault(0);
        addressBookService.updateById(addressBook1);

        addressBook.setIsDefault(1);
        addressBookService.updateById(addressBook);
        log.info("addressBook = {}", addressBook);
        return R.success(addressBook);
    }

    @PutMapping
    public R<String> update(@RequestBody AddressBook addressBook, HttpSession session) {
        addressBookService.updateById(addressBook);
        return R.success("保存成功");
    }

    @GetMapping("/{id}")
    public R<AddressBook> getById(@PathVariable String id) {
        AddressBook addressBook = addressBookService.getById(id);
        return R.success(addressBook);
    }

    @DeleteMapping
    public R<String> remove(String ids) {
        addressBookService.removeById(ids);
        return R.success("删除成功");
    }

    @GetMapping("/default")
    public R<AddressBook> getDefault() {
        LambdaQueryWrapper<AddressBook> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AddressBook::getIsDefault, 1);
        AddressBook addressBook = addressBookService.getOne(wrapper);
        return R.success(addressBook);
    }
}
