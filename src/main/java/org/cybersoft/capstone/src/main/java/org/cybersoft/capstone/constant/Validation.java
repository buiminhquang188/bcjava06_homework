package org.cybersoft.capstone.constant;

public enum Validation {
    IS_REQUIRED(" is required");

    private final String text;

    Validation(String text) {
        this.text = text;
    }

    public String getText(String fieldName) {
        return fieldName + text;
    }
}
