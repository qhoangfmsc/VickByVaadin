package com.athenaweb.ui.layout;

import com.athenaweb.ui.components.navbar.NavbarVick;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;

@PageTitle("ViCK")
public class MainLayout extends AppLayout {
    public MainLayout() {
        buildTemplate();
    }

    public void buildTemplate() {
        NavbarVick navbar = new NavbarVick();
        addToNavbar(navbar);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
    }
}
