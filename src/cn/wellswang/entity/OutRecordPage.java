package cn.wellswang.entity;

public class OutRecordPage {
    private Integer recordrId;
    private String goodsSku;
    private String goodsName;
    private Integer outNumber;
    private String recordTime;

    public Integer getRecordrId() {
        return recordrId;
    }

    public void setRecordrId(Integer recordrId) {
        this.recordrId = recordrId;
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

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }
}
