package com.athenaweb.ui.components.container;

import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Tag("div")
public class Box extends VerticalLayout implements ThemableLayout, FlexComponent, ClickNotifier<VerticalLayout> {
    public Box() {
        this.setWidth("100%");
        this.setSpacing(false);
        this.setPadding(false);
        this.getStyle()
                .set("border-radius", "10px")
                .set("box-shadow", "0 0.5em 1em -0.125em rgba(10, 10, 10, 0.1), 0 0px 0 1px rgba(10, 10, 10, 0.02)")
                .set("overflow", "hidden");
    }

    public Box(Component... children) {
        this();
        this.add(children);
    }
}
