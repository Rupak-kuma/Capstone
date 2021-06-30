package com.hcl.capstone.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.capstone.entity.Image;

@Repository
public interface FileDBRepository extends JpaRepository<Image, String> {

}
