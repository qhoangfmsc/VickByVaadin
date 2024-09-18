package com.athenaweb.ui.components.navbar;

import com.athenaweb.ui.views.MainView;
import com.athenaweb.ui.views.page.LoginView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

public class NavbarVick extends Composite<HorizontalLayout> {
    public NavbarVick() {
        getContent().getStyle()
                .set("width", "100%")
                .set("padding", "1rem 4rem")
                .set("justify-content", "space-between")
                .set("border-bottom", "3px solid var(--vick-primary)")
                .set("filter", "drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25))");

//        LEFT NAV
        HorizontalLayout leftNavbar = buildLeftNavBar();
        getContent().add(leftNavbar);

//        RIGHT NAV
        HorizontalLayout rightNavbar = buildRightNavBar();
        getContent().add(rightNavbar);
    }

    private HorizontalLayout buildLeftNavBar() {
        HorizontalLayout leftNavbar = new HorizontalLayout();
        Image vickLogo = new Image("https://stalkuat.hanzo.finance/static/image/stalk-01.svg", "vickLogo");
        vickLogo.getStyle()
                .set("width", "8rem");
        Anchor linkIndex = new Anchor("/", vickLogo);

        leftNavbar.add(linkIndex);

        return leftNavbar;
    }

    private HorizontalLayout buildRightNavBar() {
        HorizontalLayout rightNavbar = new HorizontalLayout();

        HorizontalLayout linkContainer = new HorizontalLayout();
        linkContainer.setAlignItems(FlexComponent.Alignment.CENTER);

        RouterLink aboutUs = new RouterLink("Về chúng tôi", MainView.class);
        aboutUs.addClassNames("has-text-grey");
        linkContainer.add(aboutUs);

        RouterLink consultants = new RouterLink("Cố vấn đầu tư", MainView.class);
        consultants.addClassNames("has-text-grey");
        linkContainer.add(consultants);

        rightNavbar.add(linkContainer);

        HorizontalLayout buttonContainer = new HorizontalLayout();
        Button registerButton = new Button("Đăng ký dịch vụ");
        registerButton.addClassNames("vick-light-primary");

        Button loginButton = new Button("Đăng nhập");
        loginButton.addClassNames("vick-primary");
        loginButton.addClickListener(buttonClickEvent -> {
            UI.getCurrent().navigate(LoginView.class);
        });

        Button phoneButton = new Button("0916 356 836", VaadinIcon.PHONE.create());
        phoneButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        phoneButton.addClickListener(event -> {
            UI.getCurrent().getPage().executeJs("window.location.href = 'tel:0916356836';");
        });

        buttonContainer.add(registerButton, loginButton, phoneButton);

        rightNavbar.add(buttonContainer);

        return rightNavbar;
    }
}
