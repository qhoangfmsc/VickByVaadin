package com.athenaweb.backend.entity;

import jakarta.persistence.Entity;

@Entity
public class Consultant extends AbstractEntity implements Cloneable {

    private String avatarlink = "";

    private String description = "";

    private String displayname = "";

    private String investmentphilosophy = "";

    private String investmentstyle = "";

    private Boolean isactive = null;

    private double rating;

    private String shortinvestmentphilosophy;

    private String type;

    public String getAvatarlink() {
        return avatarlink;
    }

    public void setAvatarlink(String avatarlink) {
        this.avatarlink = avatarlink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getInvestmentphilosophy() {
        return investmentphilosophy;
    }

    public void setInvestmentphilosophy(String investmentphilosophy) {
        this.investmentphilosophy = investmentphilosophy;
    }

    public String getInvestmentstyle() {
        return investmentstyle;
    }

    public void setInvestmentstyle(String investmentstyle) {
        this.investmentstyle = investmentstyle;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getShortinvestmentphilosophy() {
        return shortinvestmentphilosophy;
    }

    public void setShortinvestmentphilosophy(String shortinvestmentphilosophy) {
        this.shortinvestmentphilosophy = shortinvestmentphilosophy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
