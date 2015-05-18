package com.springapp.dao;

import com.springapp.dao.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: au011262
 * Date: 10/02/14
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ShopRepository extends JpaRepository<Shop, Long> {

    public List<Shop> findByName(String name);

    @Query("select s from Shop s where s.staffName = ?1")
    public List<Shop> findByStaff(String staffName);
}
