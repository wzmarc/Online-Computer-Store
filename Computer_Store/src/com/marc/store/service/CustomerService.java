package com.marc.store.service;

import com.marc.store.domain.Customer;

public interface CustomerService {

    /**
     * 处理客户登录
     * @param customer
     * @return 登录成功返回true,登录失败返回false
     */
    boolean login(Customer customer);

    /**
     * 处理客户注册
     * @param customer
     * @throws ServiceException 注册失败抛出异常
     */
    void register(Customer customer) throws ServiceException;

}
