package com.hcl.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.capstone.entity.FileStorageService;
import com.hcl.capstone.entity.Image;
import com.hcl.capstone.entity.Menu;
import com.hcl.capstone.exception.MenuException;
import com.hcl.capstone.service.IImageService;
import com.hcl.capstone.service.IMenuService;

@CrossOrigin
@RestController
@RequestMapping("/menus")
public class MenuController {

	@Autowired
	private FileStorageService service;
	@Autowired
	private IMenuService iMenuService;
	@Autowired
	IImageService iimageService;

	@GetMapping("/menuList")
	public ResponseEntity<List<Menu>> displayAllMenu() {
		List<Menu> menuList = iMenuService.displayAllMenu();
		return new ResponseEntity<List<Menu>>(menuList, HttpStatus.OK);
	}

	@GetMapping("/getMenuByRestaurantId/{id}")
	public ResponseEntity<List<Menu>> getByRestaurantId(@PathVariable("id") long id) {
		List<Menu> menuList = iMenuService.getMenuByRestaurantId(id);
		return new ResponseEntity<List<Menu>>(menuList, HttpStatus.OK);
	}

	@PostMapping("/addMenu")
	public ResponseEntity<Menu> addNewMenu(@RequestBody Menu menu) {
		Menu menu1 = iMenuService.addMenu(menu);
		return new ResponseEntity<Menu>(menu1, HttpStatus.OK);
	}

	@GetMapping("/getSingleMenu/{id}")
	public ResponseEntity<Menu> getSingleMenu(@PathVariable("id") long id) throws MenuException {
		Menu menu1 = iMenuService.getSingleMenuById(id);
		return new ResponseEntity<Menu>(menu1, HttpStatus.OK);
	}

	@GetMapping("getImage/{id}")
	public ResponseEntity<Image> getImage(@PathVariable("id") String id) throws MenuException {
		Image img = iimageService.getImage(id);
		return new ResponseEntity<Image>(img, HttpStatus.OK);
	}

	@PutMapping("/updateMenu")
	public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) throws MenuException {
		Menu menu1 = iMenuService.updateMenu(menu);
		return new ResponseEntity<Menu>(menu1, HttpStatus.OK);
	}

	@DeleteMapping("/deleteMenu/{id}")
	public ResponseEntity<Object> deleteMenu(@PathVariable("id") long id) throws MenuException {
		iMenuService.deleteMenuById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveFile(@RequestParam("file") MultipartFile file) {
		service.save(file);
		String message = "save successfully";
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

}
