package com.athenaweb.ui.components.footer;

import com.athenaweb.backend.entity.MenuFooter;
import com.athenaweb.backend.service.MenuFooterService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;
import java.util.function.Consumer;

public class FooterVick extends Composite<HorizontalLayout> {
    private final MenuFooterService menuFooterService;

    public FooterVick(MenuFooterService menuFooterService) {
        this.menuFooterService = menuFooterService;

        getContent().setClassName("has-background-primary has-text-white");
        getContent().getStyle()
                .set("width", "100%")
                .set("padding", "3rem");

        buildSocialMedia();
        buildDetailsInfo();
        buildLinksInfo();
    }

    private void buildSocialMedia() {
        Image vickLogo = new Image("https://stalkuat.hanzo.finance/static/image/stalk-white.svg", "Vick Logo");
        vickLogo.getStyle().set("width", "10rem");

        H4 title = new H4("THEO DÕI CHÚNG TÔI");
        title.getStyle().set("margin-top", "3rem");
        title.getStyle().set("color", "#fff");

        List<String[]> socialLinks = List.of(
                new String[]{"https://stalkuat.hanzo.finance/static/image/fb.png", "facebookImg", "https://www.facebook.com/vick.com.vn"},
                new String[]{"https://stalkuat.hanzo.finance/static/image/youtube.png", "youtubeImg", "https://www.youtube.com/vick.com.vn"},
                new String[]{"https://image.vick.vn/21232f297a57a5a743894a0e4a801fc3/logo-telegram_23193687900018371.png", "telegramImg", "https://telegram.com/vick.com.vn"},
                new String[]{"https://image.vick.vn/21232f297a57a5a743894a0e4a801fc3/logo-tiktok_9149934418103979.png", "tiktokImg", "https://tiktok.com/vick.com.vn"}
        );

        HorizontalLayout socialContainer = new HorizontalLayout();
        socialLinks.forEach(linkData -> {
            Image img = new Image(linkData[0], linkData[1]);
            img.getStyle().set("height", "2rem");

            Anchor anchor = new Anchor(linkData[2], img);
            anchor.setTarget("_blank");

            socialContainer.add(anchor);
        });

        VerticalLayout container = new VerticalLayout(vickLogo, title, socialContainer);
        container.getStyle().set("width", "60%");

        getContent().add(container);
    }

    private void buildDetailsInfo() {
        H3 title = new H3("CÔNG TY CỔ PHẦN VICK");
        title.getStyle()
                .set("margin-bottom", "1rem")
                .set("color", "#fff");

        Span emailTitle = new Span("Địa chỉ: ");
        emailTitle.getStyle()
                .set("color", "#fff")
                .set("font-weight", "bold");

        Paragraph address = new Paragraph(
                emailTitle,
                new Span("Tầng 11, Tòa nhà HDTC, 36 Bùi Thị Xuân, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh, Việt Nam.")
        );
        address.getStyle().set("max-width", "30rem");

        Span taxTitle = new Span("Mã số Thuế: ");
        taxTitle.getStyle()
                .set("color", "#fff")
                .set("font-weight", "bold");

        Paragraph tax = new Paragraph(
                taxTitle,
                new Span("0316298093 do Sở Kế Hoạch Và Đầu Tư TP Hồ Chí Minh cấp ngày 2020-05-28.")
        );
        tax.getStyle().set("max-width", "30rem");

        Span ownerTitle = new Span("NĐDPL: ");
        ownerTitle.getStyle()
                .set("color", "#fff")
                .set("font-weight", "bold");

        Paragraph owner = new Paragraph(
                ownerTitle,
                new Span("NGUYỄN HỒNG ĐIỆP.")
        );
        owner.getStyle().set("max-width", "30rem");

        Span emailContactTitle = new Span("Email: ");
        emailContactTitle.getStyle()
                .set("color", "#fff")
                .set("font-weight", "bold");

        Span hotlineTitle = new Span("| Hotline: ");
        hotlineTitle.getStyle()
                .set("color", "#fff")
                .set("font-weight", "bold");

        Paragraph emailAndHotline = new Paragraph(
                emailContactTitle,
                new Span("info@vick.vn "),
                hotlineTitle,
                new Span("0916 356 836")
        );
        emailAndHotline.getStyle().set("max-width", "30rem");

        Image verified = new Image("https://stalkuat.hanzo.finance/static/image/logoSaleNoti.png", "verified");
        verified.getStyle()
                .set("width", "10rem");

        H3 titleBanking = new H3("NGÂN HÀNG THANH TOÁN");
        titleBanking.getStyle().set("color", "#fff");

        Image bank = new Image("https://stalkuat.hanzo.finance/static/image/thebank_vietcombank.jpeg", "Vietcombank");
        bank.getStyle()
                .set("width", "10rem")
                .set("border-radius", "10px");

        VerticalLayout container = new VerticalLayout(title, address, tax, owner, emailAndHotline, verified, titleBanking, bank);
        getContent().add(container);
    }

    private void buildLinksInfo() {
        getDataMenuFooterWithCallback(this::renderUIMenuFooter);
    }

    private void getDataMenuFooterWithCallback(Consumer<List<MenuFooter>> callback) {
        List<MenuFooter> menuFooter = menuFooterService.findDataList();
        callback.accept(menuFooter);
    }

    private void renderUIMenuFooter(List<MenuFooter> menuFooterList) {
        VerticalLayout container = new VerticalLayout();
        container.getStyle().set("width", "60%");

        H3 title = new H3("LIÊN KẾT");
        title.getStyle().set("color", "#fff");
        container.add(title);

        menuFooterList.forEach(menu -> {
            Anchor menuItem = new Anchor(menu.getMenuurl(), menu.getMenuname());
            menuItem.setClassName("has-text-white");
            container.add(menuItem);
        });

        getContent().add(container);
    }
}
