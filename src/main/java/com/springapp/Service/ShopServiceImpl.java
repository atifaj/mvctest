package com.springapp.Service;

import com.springapp.dao.ShopRepository;
import com.springapp.dao.model.Shop;
import com.springapp.mvc.model.ShopForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: au011262
 * Date: 8/04/14
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional(readOnly = true)
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopRepository shopRepository;

    @Override
    @Transactional
    public void addShop(ShopForm shopForm) {
        Shop s = new Shop();
        s.setName(shopForm.getName());
        s.setStaffName(shopForm.getStaffName());
        shopRepository.save(s);//To change body of implemented methods use File | Settings | File Templates.*//**//**/
    }

    @Override
    public List findAllShops() {
        return shopRepository.findAll();
        /*return null;*/
    }

    public List findByName(String name) {
        return shopRepository.findByName(name);
    }

    public List findByStaff(String name) {
        return shopRepository.findByStaff(name);
    }
}
