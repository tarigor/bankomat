package com.senla.bankomat.service.impl;

import com.senla.bankomat.entity.Client;
import com.senla.bankomat.service.BaseService;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileServiceImpl extends BaseService {

    private static final FileServiceImpl fileService = new FileServiceImpl();

    public static FileServiceImpl getInstance() {
        return fileService;
    }

    public static final String PATHNAME = "src/main/resources/input_data.txt";
    private final String PATH = "src/main/resources/data.txt";

    public void loadFromFile() throws IOException {
        Scanner scanner = new Scanner(new File(PATH));
        getClients().clear();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            storeToArray(line);
        }
    }

    private void storeToArray(String line) {
        String[] clientData = line.split(" ");
        clients.add(new Client(
                Integer.parseInt(clientData[0]),
                parseToInt(clientData[1].split("-")),
                Integer.parseInt(clientData[2]),
                Double.parseDouble(clientData[3]),
                Long.parseLong(clientData[4])));
    }

    private int[] parseToInt(String[] strings) {
        int[] cardData = new int[4];
        for (int i = 0; i < strings.length; i++) {
            cardData[i] = Integer.parseInt(strings[i]);
        }
        return cardData;
    }

    public void writeToFile(ArrayList<Client> clientArrayList) throws IOException {
        FileWriter fw = new FileWriter(PATH,false);
        for (Client client : clientArrayList) {
            fw.write(client.toFileString());
            fw.append('\n');
        }
        fw.close();
    }
}
