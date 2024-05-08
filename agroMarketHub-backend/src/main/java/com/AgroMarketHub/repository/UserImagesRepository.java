package com.AgroMarketHub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AgroMarketHub.entity.UserImages;

@Repository
public interface UserImagesRepository extends JpaRepository<UserImages, Long>{
	
	@Query("SELECT ui.url FROM UserImages ui WHERE ui.user.id = :userId")
	List<String> getImageUrlByUserId(@Param("userId") Long userId);
}
