package com.athenaweb.ui.components.carousel;

import com.athenaweb.backend.entity.Banner;
import com.athenaweb.backend.service.BannerService;
import com.flowingcode.vaadin.addons.carousel.Carousel;
import com.flowingcode.vaadin.addons.carousel.Slide;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class CarouselVickBanner extends Composite<VerticalLayout> {
    private final BannerService bannerService;

    public CarouselVickBanner(BannerService bannerService) {
        this.bannerService = bannerService;
        System.out.println("CarouselVickBanner running...");

        getContent().getStyle().set("padding", "0");
//        getDataBanner().thenAccept(this::updateUIBanner);
        getDataBannerWithCallback(this::updateUIBannerWithCallback);
    }

//    private void updateUIBanner(List<Banner> banners) {
//        System.out.println("CarouselVickBanner updateUIBanner running... " + getUI() + " and " + UI.getCurrent());
//        getUI().ifPresent(ui -> ui.access(() -> {
//            System.out.println("CarouselVickBanner updateUIBanner access running... " + ui);
//            if (banners != null && !banners.isEmpty()) {
//                Slide[] slides = banners.stream().map(banner -> {
//                    try {
//                        String slideTitle = banner.getBannername();
//                        String slideImageUrl = banner.getDesktop();
//
//                        // Create an Image component
//                        Image image = new Image(slideImageUrl, slideTitle);
//                        image.setAlt(slideTitle);
//                        image.getStyle()
//                                .set("width", "100%")
//                                .set("height", "80%")
//                                .set("object-fit", "cover");
//
//                        return new Slide(image);
//                    } catch (Exception e) {
//                        return null;
//                    }
//                }).filter(Objects::nonNull).toArray(Slide[]::new);
//
//                Carousel carousel = new Carousel();
//                carousel.setSlides(slides);
//                carousel.setSizeFull();
//                getContent().add(carousel);
//            } else {
//                System.out.println("Banners empty");
//            }
//        }));
//    }
//
//    private CompletableFuture<List<Banner>> getDataBanner() {
//        System.out.println("CarouselVickBanner getDataBanner running...");
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                return bannerService.findDataList();
//            } catch (Exception e) {
//                System.out.println(e.toString());
//                return Collections.emptyList();
//            }
//        });
//    }

    private void getDataBannerWithCallback(Consumer<List<Banner>> callback) {
        List<Banner> banners = bannerService.findDataList();
        callback.accept(banners);
    }

    private void updateUIBannerWithCallback(List<Banner> banners) {
        Slide[] slides = banners.stream().map(banner -> {
            try {
                String slideTitle = banner.getBannername();
                String slideImageUrl = banner.getDesktop();

                // Create an Image component
                Image image = new Image(slideImageUrl, slideTitle);
                image.setAlt(slideTitle);
                image.getStyle()
                        .set("width", "100%")
                        .set("height", "80%")
                        .set("object-fit", "cover");

                return new Slide(image);
            } catch (Exception e) {
                return null;
            }
        }).filter(Objects::nonNull).toArray(Slide[]::new);

        Carousel carousel = new Carousel();
        carousel.setSlides(slides);
        carousel.setSizeFull();
        getContent().add(carousel);
    }
}
