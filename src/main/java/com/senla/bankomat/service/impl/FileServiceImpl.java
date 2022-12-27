package com.senla.bankomat.service.impl;

import com.senla.bankomat.entity.Client;
import com.senla.bankomat.service.BaseService;
import com.senla.bankomat.service.IFileService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileServiceImpl extends BaseService implements IFileService {

    private static final FileServiceImpl fileService = new FileServiceImpl();
    private final String PATH = System.getProperty("user.dir") + "/src/main/resources/data.txt";

    public static FileServiceImpl getInstance() {
        return fileService;
    }

    @Override
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

    @Override
    public void writeToFile(ArrayList<Client> clientArrayList) throws IOException {
        FileWriter fw = new FileWriter(PATH, false);
        for (Client client : clientArrayList) {
            fw.write(client.toFileString());
            fw.append('\n');
        }
        fw.close();
    }
}
