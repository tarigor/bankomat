package com.senla.bankomat.constants;

public enum MenuItems {
    CHECK_BALANCE("Check Balance"),
    TOP_UP("Top-up Balance"),
    WITHDRAW("Withdraw money"),
    LOG_OUT("log-out"),
    LOGIN("Log-in");

    private final String description;

    MenuItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
