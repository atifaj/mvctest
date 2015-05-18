package com.springapp.Service;

import com.springapp.mvc.model.ShopForm;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: au011262
 * Date: 8/04/14
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ShopService {
    public void addShop(ShopForm shopForm);
    public List findAllShops();
    public List findByName(String name);
    public List findByStaff(String name);
}
