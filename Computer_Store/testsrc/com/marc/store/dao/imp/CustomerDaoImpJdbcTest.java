package com.marc.store.dao.imp;

import com.marc.store.dao.CustomerDao;
import com.marc.store.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerDaoImpJdbcTest {

    CustomerDao dao;

    @BeforeEach
    void setUp() {
        dao = new CustomerDaoImpJdbc();
    }

    @AfterEach
    void tearDown() {
        dao = null;
    }

    @Test
    void findByPk() {

        Customer customer = dao.findByPk("tony");
        assertNotNull(customer);
        assertEquals("tony", customer.getId());
        assertEquals("关东升", customer.getName());
        assertEquals("111", customer.getPassword());
        assertEquals("北京丰台", customer.getAddress());
        assertEquals("88888888", customer.getPhone());
        assertEquals(11111111111L, customer.getBirthday().getTime());

    }

    @Test
    void findAll() {
        List<Customer> list = dao.findAll();
        assertEquals(list.size(), 1);
    }

    @Test
    void create() {
        Customer customer = new Customer();
        customer.setId("tom");
        customer.setName("张三");
        customer.setPassword("123");
        customer.setAddress("黑龙江");
        customer.setPhone("11111111");
        customer.setBirthday(new Date(111111112341L));

        dao.create(customer);
        // 按照主键查询
        Customer customer1 =  dao.findByPk("tom");
        assertEquals("tom", customer1.getId());
        assertEquals("张三", customer1.getName());
        assertEquals("123", customer1.getPassword());
        assertEquals("黑龙江", customer1.getAddress());
        assertEquals("11111111", customer1.getPhone());
        assertEquals(111111112341L, customer1.getBirthday().getTime());

    }

    @Test
    void modify() {

        Customer customer = new Customer();
        customer.setId("tom");
        customer.setName("李四");
        customer.setPassword("567");
        customer.setAddress("吉林");
        customer.setPhone("56777777");
        customer.setBirthday(new Date(1111111125541L));

        dao.modify(customer);
        // 按照主键查询
        Customer customer1 =  dao.findByPk("tom");
        assertEquals("tom", customer1.getId());
        assertEquals("李四", customer1.getName());
        assertEquals("567", customer1.getPassword());
        assertEquals("吉林", customer1.getAddress());
        assertEquals("56777777", customer1.getPhone());
        assertEquals(1111111125541L, customer1.getBirthday().getTime());
    }

    @Test
    void remove() {

        dao.remove("tom");
        // 按照主键查询
        Customer customer =  dao.findByPk("tom");
        assertNull(customer);
    }
}