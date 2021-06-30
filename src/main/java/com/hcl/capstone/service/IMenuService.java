package com.hcl.capstone.service;

import java.util.List;

import com.hcl.capstone.entity.Image;
import com.hcl.capstone.entity.Menu;
import com.hcl.capstone.exception.MenuException;

public interface IMenuService {

	public List<Menu> displayAllMenu();

	public Menu addMenu(Menu menu);

	public Menu getSingleMenuById(long id) throws MenuException;

	public Menu updateMenu(Menu menu) throws MenuException;

	public void deleteMenuById(long id) throws MenuException;

	public List<Menu> getMenuByRestaurantId(long id);

	

}
