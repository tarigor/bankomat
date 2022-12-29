package com.senla.bankomat.constants;

public enum DataType {
    CLIENT("client_data.txt"), BANKOMAT("bankomat_data.txt");

    private final String fileName;

    DataType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
