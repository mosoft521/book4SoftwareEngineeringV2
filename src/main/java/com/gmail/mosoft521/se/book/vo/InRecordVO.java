package com.gmail.mosoft521.se.book.vo;

import java.util.Date;
import java.util.List;

public class InRecordVO {
    private Integer id;

    private Date recordDate;

    private Date createTime;

    private Integer createBy;

    //入库的总数量
    private int amount;

    //该入库记录所对应的书的入库记录
    private List<BookInRecordVO> bookInRecordVOList;

    //入库书的名称, 以逗号隔开
    private String bookNames;

    public InRecordVO() {
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

    public List<BookInRecordVO> getBookInRecordVOList() {
        return bookInRecordVOList;
    }

    public void setBookInRecordVOList(List<BookInRecordVO> bookInRecordVOList) {
        this.bookInRecordVOList = bookInRecordVOList;
    }

    public String getBookNames() {
        return bookNames;
    }

    public void setBookNames(String bookNames) {
        this.bookNames = bookNames;
    }
}
