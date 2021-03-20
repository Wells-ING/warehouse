package cn.wellswang.entity;

public class BadPage {
    private Integer badId;
    private Integer orderId;
    private String goodsSku;
    private String goodsName;
    private String managerName;
    private Integer badBoxNumber;
    private String badDecoration;

    public Integer getBadId() {
        return badId;
    }

    public void setBadId(Integer badId) {
        this.badId = badId;
    }

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


    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getBadBoxNumber() {
        return badBoxNumber;
    }

    public void setBadBoxNumber(Integer badBoxNumber) {
        this.badBoxNumber = badBoxNumber;
    }

    public String getBadDecoration() {
        return badDecoration;
    }

    public void setBadDecoration(String badDecoration) {
        this.badDecoration = badDecoration;
    }
}
