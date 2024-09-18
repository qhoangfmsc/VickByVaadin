package com.athenaweb.backend.service;

import com.athenaweb.backend.entity.Banner;
import com.athenaweb.backend.repository.BannerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    private final BannerRepository repository;
    public BannerService(BannerRepository repository) {this.repository = repository;}
    public List<Banner> findDataList() {
        return repository.findAll();
    }

    @PostConstruct
    public void createMockupData() {
        if (repository.count() == 0) {
            repository.saveAll(List.of(
                    createBanner("Chương trình Sale T11/2023",
                            "https://image.vick.vn/21232f297a57a5a743894a0e4a801fc3/banner-web_13410433804027354.png"),
                    createBanner("Cách lấy mã giới thiệu",
                            "https://image.vick.vn/21232f297a57a5a743894a0e4a801fc3/banner-web-cach-lay-ma-gioi-thieu_7434830245863009.png")
            ));
        }
    }

    private Banner createBanner(String name, String desktop) {
        Banner banner = new Banner();
        banner.setBannername(name);
        banner.setDesktop(desktop);
        return banner;
    }
}
