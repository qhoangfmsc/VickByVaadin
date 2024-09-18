package com.athenaweb.backend.repository;

import com.athenaweb.backend.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository <Banner, Long> {
}
