package com.athenaweb.ui.views;

import com.athenaweb.backend.service.BannerService;
import com.athenaweb.backend.service.ConsultantService;
import com.athenaweb.backend.service.MenuFooterService;
import com.athenaweb.ui.components.carousel.CarouselVickBanner;
import com.athenaweb.ui.components.consultant.ConsultantList;
import com.athenaweb.ui.components.container.Box;
import com.athenaweb.ui.components.container.Iframe;
import com.athenaweb.ui.components.footer.FooterVick;
import com.athenaweb.ui.layout.MainLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@PageTitle("ViCK | Trang chủ")
@Route(value = "", layout = MainLayout.class)
public class MainView extends AppLayout {
    private final BannerService bannerService;
    private final ConsultantService consultantService;
    private final MenuFooterService menuFooterService;
    VerticalLayout mainLayout = new VerticalLayout();

    public MainView(BannerService bannerService, ConsultantService consultantService, MenuFooterService menuFooterService) {
        this.bannerService = bannerService;
        this.consultantService = consultantService;
        this.menuFooterService = menuFooterService;

        buildMainContent();
    }

    private void buildMainContent() {
        mainLayout.getStyle().set("padding", "0");
        buildBannerCarousel();
        buildMainLayout();
        buildFooter();

        setContent(mainLayout);
    }

    private void buildBannerCarousel() {
        CarouselVickBanner carousel = new CarouselVickBanner(bannerService);
        mainLayout.add(carousel);
    }

    private void buildMainLayout() {
        HorizontalLayout mainContent = new HorizontalLayout();
        mainContent.setWidth("100%");

        VerticalLayout leftContent = buildLeftContent();
        mainContent.add(leftContent);

        VerticalLayout rightContent = buildRightContent();
        mainContent.add(rightContent);

        mainLayout.add(mainContent);
    }

    private VerticalLayout buildLeftContent() {
        ConsultantList consultantList = new ConsultantList(consultantService);

        VerticalLayout layout = new VerticalLayout();
        layout.add(consultantList);

        return layout;
    }

    private VerticalLayout buildRightContent() {
//        INDEX CHART
        Iframe iframe = new Iframe("https://stalkuat.hanzo.finance/page/tradingviewindex?symbol=VNINDEX");
        iframe.getStyle().set("height", "25rem");

        H2 header = new H2("Biểu đồ INDEX");
        header.setClassName("has-background-secondary has-text-white");
        header.getStyle().set("padding", "0.5rem 1rem");

        Box indexChart = new Box(
                header,
                iframe
        );

//        MARKET FLUCTUATIONS
        Image image = new Image("https://stalkuat.hanzo.finance/static/image/dien_bien_thi_truong.png", "Market Fluctuations");
        image.setWidth("100%");
        image.setHeight("30rem");
        image.getStyle().set("object-fit", "cover");

        Button imageButton = new Button(image);
        imageButton.setWidth("100%");
        imageButton.setHeight("25rem");
        imageButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        imageButton.addClickListener(event -> {
            new Notification("Tóm tắt diễn biến thị trường");
        });

        Box marketFluctuationsBox = new Box(imageButton);

        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("50%");
        layout.getStyle().set("padding", "3rem");
        layout.add(indexChart);
        layout.add(marketFluctuationsBox);

        return layout;
    }

    private void buildFooter() {
        FooterVick footer = new FooterVick(menuFooterService);
        mainLayout.add(footer);
    }
}
