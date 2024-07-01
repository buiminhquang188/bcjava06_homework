package org.cybersoft.capstone.constant;

public enum Status {
    SUCCESS("Success"), FAILED("Failed");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
