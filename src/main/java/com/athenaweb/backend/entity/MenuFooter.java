package com.athenaweb.backend.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class MenuFooter extends AbstractEntity implements Cloneable {

    @NotNull
    @NotEmpty
    private String menuname = "";

    @NotNull
    @NotEmpty
    private String menuurl = "";

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }
}
