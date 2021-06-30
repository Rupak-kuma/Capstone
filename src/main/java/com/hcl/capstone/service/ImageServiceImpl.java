package com.hcl.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entity.Image;
import com.hcl.capstone.repository.FileDBRepository;
@Service("ImageService")
public class ImageServiceImpl implements IImageService{
	
	
	@Autowired
	private FileDBRepository fileDBRepository;
	public Image getImage(String id) {
		  return fileDBRepository.findById(id).get();
		}

}
