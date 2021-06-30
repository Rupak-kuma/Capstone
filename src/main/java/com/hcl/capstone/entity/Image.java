package com.hcl.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="image")
public class Image {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="image_id")
    private int imageId1;
    
    @Column(name="url")
    private int url;

	public int getImageId1() {
		return imageId1;
	}

	public void setImageId1(int imageId1) {
		this.imageId1 = imageId1;
	}

	public int getUrl() {
		return url;
	}

	public void setUrl(int url) {
		this.url = url;
	}

	public Image(int imageId1, int url) {
		super();
		this.imageId1 = imageId1;
		this.url = url;
	}
	
}