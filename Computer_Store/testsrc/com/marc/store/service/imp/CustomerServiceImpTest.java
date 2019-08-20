package com.marc.store.service.imp;

import com.marc.store.domain.Customer;
import com.marc.store.service.CustomerService;
import com.marc.store.service.ServiceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImpTest {

    CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImp();
    }

    @AfterEach
    void tearDown() {
        customerService = null;
    }

    @Test
    @DisplayName("登录成功")
    void login1() {

        Customer customer = new Customer();
        customer.setId("tony");
        customer.setPassword("111");

        assertTrue(customerService.login(customer));
        assertNotNull(customer);
        assertEquals("tony", customer.getId());
        assertEquals("关东升", customer.getName());
        assertEquals("111", customer.getPassword());
        assertEquals("北京丰台", customer.getAddress());
        assertEquals("88888888", customer.getPhone());
        assertEquals(11111111111L, customer.getBirthday().getTime());

    }


    @Test
    @DisplayName("登录失败")
    void login2() {

        Customer customer = new Customer();
        customer.setId("tony");
        customer.setPassword("123");
        assertFalse(customerService.login(customer));

    }


    @Test
    @DisplayName("注册成功")
    void register1() throws ServiceException {

        Customer customer = new Customer();
        customer.setId("tom");
        customer.setName("张三");
        customer.setPassword("123");
        customer.setAddress("黑龙江");
        customer.setPhone("11111111");
        customer.setBirthday(new Date(111111112341L));

        customerService.register(customer);

        Customer customer1 = new Customer();
        customer1.setId("tom");
        customer1.setPassword("123");

        customerService.login(customer1);
        assertNotNull(customer1);
        assertEquals("tom", customer1.getId());
        assertEquals("张三", customer1.getName());
        assertEquals("123", customer1.getPassword());
        assertEquals("黑龙江", customer1.getAddress());
        assertEquals("11111111", customer1.getPhone());
        assertEquals(111111112341L, customer1.getBirthday().getTime());

    }

    @Test
    @DisplayName("客户ID已经存在")
    void register2() {

        Customer customer = new Customer();
        customer.setId("tom");
        customer.setPassword("123");

        assertThrows(ServiceException.class, () -> {
            customerService.register(customer);
        });

    }
}