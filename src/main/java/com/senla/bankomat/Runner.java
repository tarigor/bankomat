package com.senla.bankomat;

import com.senla.bankomat.exceptions.*;
import com.senla.bankomat.service.constants.MenuItems;
import com.senla.bankomat.service.impl.ConsoleMenuViewServiceImpl;
import com.senla.bankomat.service.impl.FileServiceImpl;
import com.senla.bankomat.service.impl.MenuRoutineImpl;

import java.io.IOException;
import java.util.Map;

public class Runner {
    private static final ConsoleMenuViewServiceImpl consoleMenuViewService = ConsoleMenuViewServiceImpl.getInstance();
    private static final MenuRoutineImpl menuRoutine = MenuRoutineImpl.getInstance();
    private static final FileServiceImpl fileService = FileServiceImpl.getInstance();

    public static void main(String[] args) {
        while (true) {
            try {
                fileService.loadFromFile();
                Map<Integer, MenuItems> menuList = consoleMenuViewService.showMenu();
                menuRoutine.menuCommandExecute(menuList);
            } catch (IOException | InputErrorException | NoSuchClientException | NoSuchCardException | AccountBlockException | ServiceMissingException e) {
                System.out.println("an exception occurred -> " + e);
            }
        }
    }
}
