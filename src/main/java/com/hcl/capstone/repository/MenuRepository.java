package com.hcl.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

 

import com.hcl.capstone.entity.Menu;

 

@Repository("menuRepository")
public interface MenuRepository extends JpaRepository<Menu, Long> {

 

    @Query(value="select * from menu where restaurant_restaurent_id=?", nativeQuery=true)
    public List<Menu> getMenuByRestaurantId(long id);

 

}