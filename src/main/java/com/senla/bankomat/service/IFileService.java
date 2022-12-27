package com.senla.bankomat.service;

import com.senla.bankomat.entity.Client;

import java.io.IOException;
import java.util.ArrayList;

public interface IFileService {

    void loadFromFile() throws IOException;
    void writeToFile(ArrayList<Client> clientArrayList) throws IOException;
}
