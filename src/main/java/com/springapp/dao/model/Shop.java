package com.springapp.dao.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: au011262
 * Date: 10/02/14
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "Shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    @Basic
    private String name;
    @Basic
    private String staffName;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
