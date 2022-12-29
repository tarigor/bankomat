package com.senla.bankomat.service;

import com.senla.bankomat.constants.DataType;
import com.senla.bankomat.entity.Client;

import java.io.IOException;
import java.util.ArrayList;

public interface IFileService {

    void loadFromFile(DataType dataType) throws IOException;

    void writeToFile(ArrayList<Client> clientArrayList) throws IOException;

    void writeToFile(double bankomatBalance) throws IOException;
}
