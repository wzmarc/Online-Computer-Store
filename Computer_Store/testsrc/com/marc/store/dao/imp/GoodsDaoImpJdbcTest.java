package com.marc.store.dao.imp;

import com.marc.store.dao.GoodsDao;
import com.marc.store.domain.Goods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoodsDaoImpJdbcTest {

    GoodsDao dao;

    @BeforeEach
    void setUp() {
        dao = new GoodsDaoImpJdbc();
    }

    @AfterEach
    void tearDown() {
        dao = null;
    }

    @Test
    void findByPk() {

        Goods goods = dao.findByPk(1L);
        assertNotNull(goods);
        assertEquals(1L, goods.getId());
        assertEquals("戴尔(DELL)成就3470高性能商用办公台式电脑整机", goods.getName());
        assertEquals(3399, goods.getPrice());
        assertEquals("戴尔(DELL)成就3470高性能商用办公台式电脑整机(八代i3-8100 8G 1T 四年上门 有线键鼠 FHD宽屏)21.5英寸 ", goods.getDescription());
        assertEquals("5ae00211N25afad2c.jpg", goods.getImage());
        assertEquals("", goods.getBrand());
        assertEquals("", goods.getCpuBrand());
        assertEquals("", goods.getCardModel());
        assertEquals("", goods.getMemoryCapacity());
        assertEquals("", goods.getCpuType());
        assertEquals("", goods.getHdCapacity());
        assertEquals("", goods.getDisplaysize());

    }

    @Test
    void findAll() {

        List<Goods> list = dao.findAll();
        assertEquals(list.size(), 34);

        Goods goods = list.get(0);
        assertNotNull(goods);
        assertEquals(1L, goods.getId());
        assertEquals("戴尔(DELL)成就3470高性能商用办公台式电脑整机", goods.getName());
        assertEquals(3399, goods.getPrice());
        assertEquals("戴尔(DELL)成就3470高性能商用办公台式电脑整机(八代i3-8100 8G 1T 四年上门 有线键鼠 FHD宽屏)21.5英寸 ", goods.getDescription());
        assertEquals("5ae00211N25afad2c.jpg", goods.getImage());
        assertEquals("", goods.getBrand());
        assertEquals("", goods.getCpuBrand());
        assertEquals("", goods.getCardModel());
        assertEquals("", goods.getCpuType());
        assertEquals("", goods.getMemoryCapacity());
        assertEquals("", goods.getHdCapacity());
        assertEquals("", goods.getDisplaysize());

    }

    @Test
    void findStartEnd() {

        List<Goods> list = dao.findStartEnd(0, 10);
        assertEquals(10, list.size());

        Goods goods = list.get(0);
        assertNotNull(goods);
        assertEquals(1L, goods.getId());
        assertEquals("戴尔(DELL)成就3470高性能商用办公台式电脑整机", goods.getName());
        assertEquals(3399, goods.getPrice());
        assertEquals("戴尔(DELL)成就3470高性能商用办公台式电脑整机(八代i3-8100 8G 1T 四年上门 有线键鼠 FHD宽屏)21.5英寸 ", goods.getDescription());
        assertEquals("5ae00211N25afad2c.jpg", goods.getImage());
        assertEquals("", goods.getBrand());
        assertEquals("", goods.getCpuBrand());
        assertEquals("", goods.getCardModel());
        assertEquals("", goods.getCpuType());
        assertEquals("", goods.getMemoryCapacity());
        assertEquals("", goods.getHdCapacity());
        assertEquals("", goods.getDisplaysize());
    }

    @Test
    void create() {

        Goods goods = new Goods();
        goods.setId(9999);
        goods.setName("苹果Mac Mini");
        goods.setPrice(5000);
        goods.setDescription("苹果Mac Mini 2018年初");
        goods.setBrand("苹果");
        goods.setCpuBrand("Intel");
        goods.setCpuType("i5");
        goods.setMemoryCapacity("8G");
        goods.setHdCapacity("500G");
        goods.setCardModel("GTX 9系/7系");
        goods.setDisplaysize("无");
        goods.setImage("aaa.jpg");

        dao.create(goods);
        Goods goods1 = dao.findByPk(9999);
        assertNotNull(goods1);
        assertEquals(9999, goods1.getId());
        assertEquals("苹果Mac Mini", goods1.getName());
        assertEquals(5000, goods1.getPrice());
        assertEquals("苹果Mac Mini 2018年初", goods1.getDescription());
        assertEquals("aaa.jpg", goods1.getImage());
        assertEquals("苹果", goods1.getBrand());
        assertEquals("Intel", goods1.getCpuBrand());
        assertEquals("i5", goods1.getCpuType());
        assertEquals("GTX 9系/7系", goods1.getCardModel());
        assertEquals("8G", goods1.getMemoryCapacity());
        assertEquals("500G", goods1.getHdCapacity());
        assertEquals("无", goods1.getDisplaysize());

    }

    @Test
    void modify() {

        Goods goods = new Goods();
        goods.setId(9999);
        goods.setName("苹果Mac Pro");
        goods.setPrice(12000);
        goods.setDescription("苹果Mac Pro笔记本 2018年初");
        goods.setBrand("苹果1");
        goods.setCpuBrand("Intel A");
        goods.setCpuType("Intel i7");
        goods.setMemoryCapacity("16G");
        goods.setHdCapacity("500G固态硬盘");
        goods.setCardModel("GTX");
        goods.setDisplaysize("15寸");
        goods.setImage("ab.jpg");

        dao.modify(goods);

        Goods goods1 = dao.findByPk(9999);
        assertNotNull(goods1);
        assertEquals(9999, goods1.getId());
        assertEquals("苹果Mac Pro", goods1.getName());
        assertEquals(12000, goods.getPrice());
        assertEquals("苹果Mac Pro笔记本 2018年初", goods.getDescription());
        assertEquals("ab.jpg", goods1.getImage());
        assertEquals("苹果1", goods1.getBrand());
        assertEquals("Intel A", goods1.getCpuBrand());
        assertEquals("Intel i7", goods1.getCpuType());
        assertEquals("GTX", goods1.getCardModel());
        assertEquals("16G", goods1.getMemoryCapacity());
        assertEquals("500G固态硬盘", goods1.getHdCapacity());
        assertEquals("15寸", goods1.getDisplaysize());

    }

    @Test
    void remove() {

        dao.remove(9999);

        Goods goods = dao.findByPk(9999);
        assertNull(goods);
    }
}