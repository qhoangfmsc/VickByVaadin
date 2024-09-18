package com.athenaweb.ui.components.container;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;

@Tag("iframe")
public class Iframe extends Component {

    public Iframe() {
        // Set default attributes for the iframe
        getElement().setAttribute("frameborder", "0");
        getElement().setAttribute("width", "100%");
        getElement().setAttribute("height", "100%");
    }

    public Iframe(String src) {
        this();
        setSource(src);
    }

    // Method to set the source URL of the iframe
    public void setSource(String src) {
        getElement().setAttribute("src", src);
    }

    // Method to set the width of the iframe
    public void setWidth(String width) {
        getElement().setAttribute("width", width);
    }

    // Method to set the height of the iframe
    public void setHeight(String height) {
        getElement().setAttribute("height", height);
    }

    // Method to set other iframe attributes like allowfullscreen, etc.
    public void setAttribute(String attribute, String value) {
        getElement().setAttribute(attribute, value);
    }
}
