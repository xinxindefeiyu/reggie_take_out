package com.example;

import com.example.entity.Employee;
import com.example.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Test
	void testSelect() {
		List<Employee> employeeList = employeeMapper.selectList(null);
		employeeList.forEach(System.out::println);
	}

	@Test
	void contextLoads() {
	}

}
