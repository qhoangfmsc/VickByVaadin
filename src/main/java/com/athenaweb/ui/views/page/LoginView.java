package com.athenaweb.ui.views.page;

import com.athenaweb.ui.layout.MainLayout;
import com.athenaweb.ui.security.AuthenticatedUser;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.internal.RouteUtil;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("ViCK | Đăng nhập")
@AnonymousAllowed
@Route(value = "/page/login", layout = MainLayout.class)
public class LoginView extends LoginOverlay implements BeforeEnterObserver {
    private final AuthenticatedUser authenticatedUser;

    public LoginView(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
        setAction(RouteUtil.getRoutePath(VaadinService.getCurrent().getContext(), getClass()));

        LoginI18n loginTemplate = LoginI18n.createDefault();
        loginTemplate.setHeader(new LoginI18n.Header());
        loginTemplate.getHeader().setTitle("Chào mừng đến với ViCK");
        loginTemplate.getHeader().setDescription("Vui lòng đăng nhập để tiếp tục");

        loginTemplate.setForm(new LoginI18n.Form());
        loginTemplate.getForm().setTitle("");
        loginTemplate.getForm().setUsername("Số điện thoại");
        loginTemplate.getForm().setPassword("Mật khẩu");
        loginTemplate.getForm().setSubmit("Đăng nhập");
        loginTemplate.getForm().setForgotPassword("Quên mật khẩu?");

        loginTemplate.getErrorMessage().setTitle("Đăng nhập thất bại!");
        loginTemplate.getErrorMessage().setMessage("Tài khoản hoặc mật khẩu chưa chính xác, vui lòng thử lại.");

        loginTemplate.setAdditionalInformation(null);

        setI18n(loginTemplate);
        setForgotPasswordButtonVisible(true);
        setOpened(true);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (authenticatedUser.get().isPresent()) {
            // Already logged in
            setOpened(false);
            event.forwardTo("");
        }

        setError(event.getLocation().getQueryParameters().getParameters().containsKey("error"));
    }
}
