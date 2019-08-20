package com.marc.store.service.imp;

import com.marc.store.dao.GoodsDao;
import com.marc.store.dao.OrderDao;
import com.marc.store.dao.OrderLineItemDao;
import com.marc.store.dao.imp.GoodsDaoImpJdbc;
import com.marc.store.dao.imp.OrderDaoImpJdbc;
import com.marc.store.dao.imp.OrderLineItemDaoImpJdbc;
import com.marc.store.domain.Goods;
import com.marc.store.domain.OrderLineItem;
import com.marc.store.domain.Orders;
import com.marc.store.service.OrdersService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrdersServiceImp implements OrdersService {

    GoodsDao goodsDao = new GoodsDaoImpJdbc();
    OrderDao orderDao = new OrderDaoImpJdbc();
    OrderLineItemDao orderLineItemDao = new OrderLineItemDaoImpJdbc();

    @Override
    public String submitOrders(List<Map<String, Object>> cart) {

        Orders orders = new Orders();
        Date date = new Date();
        // 订单Id
        String ordersid = String.valueOf(date.getTime())
                + String.valueOf((int) (Math.random() * 100));// random, let ids different.
        orders.setId(ordersid);
        orders.setOrderDate(date);
        orders.setStatus(1); //待确认
        orders.setTotal(0.0f);
        // 将订单信息插入到数据库中
        orderDao.create(orders);
        // 商品总金额
        double total = 0.0;

        for (Map item : cart) {
            // item结构 [商品id， 数量]
            Long goodsid = (Long) item.get("goodsid");
            Integer quantity = (Integer) item.get("quantity");
            Goods goods = goodsDao.findByPk(goodsid);
            // 小计金额
            double subtotal = quantity * goods.getPrice();
            total += subtotal;

            OrderLineItem lineItem = new OrderLineItem();
            lineItem.setQuantity(quantity);
            lineItem.setGoods(goods);
            lineItem.setOrders(orders);
            lineItem.setSubTotal(subtotal);

            // 将订单详细插入到数据库
            orderLineItemDao.create(lineItem);
        }

        orders.setTotal(total);
        // 更新订单数据库
        orderDao.modify(orders); // modify the total money in the orders.

        return ordersid;
    }
}
