package com.hcl.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entity.Image;
import com.hcl.capstone.entity.Menu;
import com.hcl.capstone.exception.MenuException;
import com.hcl.capstone.repository.FileDBRepository;
import com.hcl.capstone.repository.MenuRepository;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private MenuRepository menuRepository;
	

	@Override
	public List<Menu> displayAllMenu() {
		return menuRepository.findAll();
	}

	@Override
	public Menu addMenu(Menu menu) {
		return menuRepository.saveAndFlush(menu);
	}

	@Override
	public Menu getSingleMenuById(long id) throws MenuException {
		if (menuRepository.findById(id).isPresent())
			return menuRepository.findById(id).get();
		else
			throw new MenuException("food does not exist");
	}

	@Override
	public Menu updateMenu(Menu menu) throws MenuException {
		if (menuRepository.findById(menu.getFoodId()).isPresent()) {
			return menuRepository.saveAndFlush(menu);
		} else {
			throw new MenuException("food does not exist");
		}
	}

	@Override
	public void deleteMenuById(long id) throws MenuException {
		if (menuRepository.findById(id).isPresent())
			menuRepository.deleteById(id);
		else
			throw new MenuException("food already deleted");
	}

	@Override
	public List<Menu> getMenuByRestaurantId(long id) {
		return menuRepository.getMenuByRestaurantId(id);
	}

	
	

}
