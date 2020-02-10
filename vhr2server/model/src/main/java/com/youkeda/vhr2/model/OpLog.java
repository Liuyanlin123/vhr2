package com.youkeda.vhr2.model;

import java.util.Date;

public class OpLog {
    private Long id;

    private Date addDate;

    private String operate;

    private Long hrid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Long getHrid() {
        return hrid;
    }

    public void setHrid(Long hrid) {
        this.hrid = hrid;
    }
}
