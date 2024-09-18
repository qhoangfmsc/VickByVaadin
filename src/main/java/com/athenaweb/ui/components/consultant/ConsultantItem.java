package com.athenaweb.ui.components.consultant;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ConsultantItem extends Composite<HorizontalLayout> implements HasSize {

    private final Avatar avatar = new Avatar();
    private final H3 displayName = new H3();
    private final Span description = new Span();
    private final H4 investmentStyle = new H4();
    private final Span investmentPhilosophy = new Span();
    private final Span rating = new Span();

    public ConsultantItem() {
        VerticalLayout columnLeft = buildLeftColumn();
        VerticalLayout columnRight = buildRightColumn();

        getContent().setAlignItems(FlexComponent.Alignment.CENTER);
        getContent().setWidth("100%");
        getContent().getStyle()
                .set("line-height", "3rem")
                .set("padding", "1rem")
                .set("margin", "1rem")
                .set("box-shadow", "0px 0px 10px rgba(0, 0, 0, 0.25)");
        getContent().add(columnLeft, columnRight);
    }

    private VerticalLayout buildLeftColumn() {
        avatar.getStyle()
                .set("width", "10rem")
                .set("height", "10rem")
                .set("object-fit", "cover")
                .set("border", "4px solid #fff")
                .set("box-shadow", "rgba(0, 0, 0, 0.33) 0px 3px 8px");

        VerticalLayout columnLeft = new VerticalLayout(avatar, rating);
        columnLeft.setWidth("40%");
        columnLeft.setAlignItems(FlexComponent.Alignment.CENTER);
        columnLeft.setPadding(false);
        columnLeft.setSpacing(false);
        return columnLeft;
    }

    private VerticalLayout buildRightColumn() {
        VerticalLayout columnRight = new VerticalLayout();
        columnRight.setHeight("100%");
        columnRight.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        columnRight.setPadding(false);
        columnRight.setSpacing(false);

        VerticalLayout columnRightTop = new VerticalLayout(displayName, investmentStyle, description);

        HorizontalLayout columnRightBotContainer = new HorizontalLayout();
        columnRightBotContainer.setWidth("100%");
        columnRightBotContainer.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        Button register = new Button("Đăng ký dịch vụ", buttonClickEvent -> {
            new Notification("Đăng ký dịch vụ");
        });
        register.addClassNames("vick-primary");

        Button more = buildMoreButton();

        columnRightBotContainer.add(register, more);
        VerticalLayout columnRightBot = new VerticalLayout(columnRightBotContainer);

        columnRight.add(columnRightTop, columnRightBot);

        return columnRight;
    }

    private Button buildMoreButton() {
        Dialog dialog = new Dialog();
        dialog.getElement().setAttribute("aria-label", "Chi tiết cố vấn " + displayName);
        VerticalLayout dialogLayout = new VerticalLayout(investmentPhilosophy);
        dialog.add(dialogLayout);

        Button more = new Button("Xem thêm");
        more.addClassNames("vick-secondary");
        more.addClickListener(event -> {
            dialog.open();
        });

        return more;
    }

    public ConsultantItem(String avatarLink, String displayName, String description, String investmentStyle,
                          String investmentPhilosophy, double rating) {
        this();
        setAvatar(avatarLink);
        setDisplayName(displayName);
        setDescription(description);
        setInvestmentStyle(investmentStyle);
        setInvestmentPhilosophy(investmentPhilosophy);
        setRating(rating);
    }

    public void setAvatar(String avatarLink) {
        this.avatar.setImage(avatarLink);
        this.avatar.setName(""); // Clears the name if using image-based avatars
    }

    public void setDisplayName(String text) {
        this.displayName.setText(text);
        this.displayName.addClassName("has-text-primary");
        this.displayName.getStyle()
                .set("width", "100%")
                .set("border-bottom", "2px solid var(--vick-primary)")
                .set("padding-bottom", "0.5rem");
    }

    public void setDescription(String text) {
        this.description.setText(text);
    }

    public void setInvestmentStyle(String text) {
        this.investmentStyle.setText(text);
        this.investmentStyle.addClassName("has-text-secondary");
    }

    public void setInvestmentPhilosophy(String text) {
        this.investmentPhilosophy.setText(text);
    }

    public void setRating(double rating) {
        this.rating.setText("Rating: " + rating);
    }
}
