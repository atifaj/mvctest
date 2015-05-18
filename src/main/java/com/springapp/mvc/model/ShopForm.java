package com.springapp.mvc.model;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created with IntelliJ IDEA.
 * User: au011262
 * Date: 23/01/14
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */

public class ShopForm {
    @NotEmpty
    String name;
    @NotBlank
    String staffName;

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

