package com.gmail.mosoft521.se.book.vo;

import java.util.Date;
import java.util.List;

public class SaleRecordVO {
    private Integer id;

    private Date recordDate;

    private Date createTime;

    private Integer createBy;

    //销售的总数量
    private int amount;
    //总价钱
    private double totalPrice;
    //书的销售记录
    private List<BookSaleRecordVO> bookSaleRecordVOList;

    //该记录中对应所有书的名称, 显示用
    private String bookNames;

    public SaleRecordVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<BookSaleRecordVO> getBookSaleRecordVOList() {
        return bookSaleRecordVOList;
    }

    public void setBookSaleRecordVOList(List<BookSaleRecordVO> bookSaleRecordVOList) {
        this.bookSaleRecordVOList = bookSaleRecordVOList;
    }

    public String getBookNames() {
        return bookNames;
    }

    public void setBookNames(String bookNames) {
        this.bookNames = bookNames;
    }
}
