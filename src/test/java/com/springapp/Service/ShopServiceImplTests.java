package com.springapp.Service;

import static org.junit.Assert.*;

import java.util.List;

import com.springapp.config.AppConfig;
import com.springapp.config.DAOConfig;
import com.springapp.config.ServiceConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: au011262
 * Date: 31/12/14
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DAOConfig.class,ServiceConfig.class})

public class ShopServiceImplTests {

    @Autowired
    private ShopService shopService;

    @Before
    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {

    }

    public void testAddShop() throws Exception {

    }

    @Test
    public void testFindAllShops() throws Exception {
        List a = shopService.findAllShops();
        assertNotNull(a);
        
    }
}
