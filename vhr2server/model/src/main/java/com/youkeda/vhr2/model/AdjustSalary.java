package com.youkeda.vhr2.model;


import java.util.Date;

public class AdjustSalary {
    private Integer id;
    // todo  不知道这个是什么东东
    private Integer eid;
    private Date adjustSalaryDate;
    private Integer beforeSalary;
    private Integer afterSalary;
    private String reason;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getAdjustSalaryDate() {
        return adjustSalaryDate;
    }

    public void setAdjustSalaryDate(Date adjustSalaryDate) {
        this.adjustSalaryDate = adjustSalaryDate;
    }

    public Integer getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(Integer beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public Integer getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(Integer afterSalary) {
        this.afterSalary = afterSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
