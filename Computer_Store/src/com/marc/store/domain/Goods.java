package com.marc.store.domain;

public class Goods {

    /* 商品id */
    private long id;
    /* 商品名称 */
    private String name;
    /* 单价 */
    private double price;
    /* 产品描述 */
    private String description;
    /* 电脑品牌 */
    private String brand;
    /* CPU品牌 */
    private String cpuBrand;
    /* CPU型号 */
    private String cpuType;
    /* 内存容量*/
    private String memoryCapacity;
    /* 硬盘容量*/
    private String hdCapacity;
    /* 显卡型号 */
    private String cardModel;
    /* 显示器尺寸*/
    private String displaysize;
    /* 电脑图片*/
    private String image;

//    private List<OrderLineItem> orderLineItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpuBrand() {
        return cpuBrand;
    }

    public void setCpuBrand(String cpuBrand) {
        this.cpuBrand = cpuBrand;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public String getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(String memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public String getHdCapacity() {
        return hdCapacity;
    }

    public void setHdCapacity(String hdCapacity) {
        this.hdCapacity = hdCapacity;
    }

    public String getCardModel() {
        return cardModel;
    }

    public void setCardModel(String cardModel) {
        this.cardModel = cardModel;
    }

    public String getDisplaysize() {
        return displaysize;
    }

    public void setDisplaysize(String displaysize) {
        this.displaysize = displaysize;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
