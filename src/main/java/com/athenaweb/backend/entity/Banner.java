package com.athenaweb.backend.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Banner extends AbstractEntity implements Cloneable {

    @NotNull
    @NotEmpty
    private String bannername = "";

    @NotNull
    @NotEmpty
    private String desktop = "";

    public String getBannername() {
        return bannername;
    }

    public void setBannername(String bannername) {
        this.bannername = bannername;
    }

    public String getDesktop() {
        return desktop;
    }

    public void setDesktop(String desktop) {
        this.desktop = desktop;
    }
}
