package com.athenaweb.backend.service;

import com.athenaweb.backend.entity.MenuFooter;
import com.athenaweb.backend.repository.MenuFooterRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuFooterService {
    private final MenuFooterRepository repository;
    public MenuFooterService(MenuFooterRepository repository) {this.repository = repository;}
    public List<MenuFooter> findDataList() {
        return repository.findAll();
    }

    @PostConstruct
    public void createMockupData() {
        if (repository.count() == 0) {
            repository.saveAll(List.of(
                    createMenu("Về chúng tôi", "/page/staticpage/ve-chung-toi"),
                    createMenu("Chính sách bảo mật", "/page/staticpage/chinh-sach-bao-mat"),
                    createMenu("Chính sách thanh toán", "/page/staticpage/chinh-sach-thanh-toan"),
                    createMenu("Đổi Trả / Hoàn Tiền", "/page/staticpage/chinh-sach-dich-vu"),
                    createMenu("Điều khoản sử dụng", "/page/staticpage/dieu-khoan-su-dung"),
                    createMenu("Hướng dẫn thanh toán VNPAY", "/page/staticpage/huong-dan-thanh-toan-vnpay"),
                    createMenu("Hướng dẫn lấy mã giới thiệu", "/page/staticpage/huong-dan-lay-ma-gioi-thieu"),
                    createMenu("Liên hệ", "/page/contact")
            ));
        }
    }

    private MenuFooter createMenu(String menuname, String menuurl) {
        MenuFooter menu = new MenuFooter();
        menu.setMenuname(menuname);
        menu.setMenuurl(menuurl);
        return menu;
    }
}
