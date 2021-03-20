package cn.wellswang.entity;

public class OrderPage {
    private Integer orderId;
    private String goodsSku;
    private String goodsName;
    private Integer goodsNumberEachBox;
    private Integer orderBoxNumber;
    private Integer sumNumber;
    private Double goodsEachPrice;
    private Double goodsSumPrice;
    private Double orderFreight;
    private Double orderDeposit;
    private Double orderSumPrice;
    private String supplierName;
    private String orderTime;
    private Integer orderStatus;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(String goodsSku) {
        this.goodsSku = goodsSku;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNumberEachBox() {
        return goodsNumberEachBox;
    }

    public void setGoodsNumberEachBox(Integer goodsNumberEachBox) {
        this.goodsNumberEachBox = goodsNumberEachBox;
    }

    public Integer getOrderBoxNumber() {
        return orderBoxNumber;
    }

    public void setOrderBoxNumber(Integer orderBoxNumber) {
        this.orderBoxNumber = orderBoxNumber;
    }

    public Integer getSumNumber() {
        return sumNumber;
    }

    public void setSumNumber(Integer sumNumber) {
        this.sumNumber = sumNumber;
    }

    public Double getGoodsEachPrice() {
        return goodsEachPrice;
    }

    public void setGoodsEachPrice(Double goodsEachPrice) {
        this.goodsEachPrice = goodsEachPrice;
    }

    public Double getGoodsSumPrice() {
        return goodsSumPrice;
    }

    public void setGoodsSumPrice(Double goodsSumPrice) {
        this.goodsSumPrice = goodsSumPrice;
    }

    public Double getOrderFreight() {
        return orderFreight;
    }

    public void setOrderFreight(Double orderFreight) {
        this.orderFreight = orderFreight;
    }

    public Double getOrderDeposit() {
        return orderDeposit;
    }

    public void setOrderDeposit(Double orderDeposit) {
        this.orderDeposit = orderDeposit;
    }

    public Double getOrderSumPrice() {
        return orderSumPrice;
    }

    public void setOrderSumPrice(Double orderSumPrice) {
        this.orderSumPrice = orderSumPrice;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
