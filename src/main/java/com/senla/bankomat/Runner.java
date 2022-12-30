package com.senla.bankomat;

import com.senla.bankomat.constants.DataType;
import com.senla.bankomat.constants.MenuItems;
import com.senla.bankomat.exceptions.*;
import com.senla.bankomat.service.impl.ConsoleMenuViewServiceImpl;
import com.senla.bankomat.service.impl.FileServiceImpl;
import com.senla.bankomat.service.impl.MenuRoutineImpl;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);
    private static final ConsoleMenuViewServiceImpl consoleMenuViewService = ConsoleMenuViewServiceImpl.getInstance();
    private static final MenuRoutineImpl menuRoutine = MenuRoutineImpl.getInstance();
    private static final FileServiceImpl fileService = FileServiceImpl.getInstance();

    public static void main(String[] args) {
        while (true) {
            try {
                fileService.loadFromFile(DataType.CLIENT);
                fileService.loadFromFile(DataType.BANKOMAT);
                Map<Integer, MenuItems> menuList = consoleMenuViewService.showMenu();
                menuRoutine.menuCommandExecute(menuList);
            } catch (IOException | InputErrorException | NoSuchClientException | NoSuchCardException
                     | AccountBlockException | ServiceMissingException | NotSufficientBalanceException
                     | MissingMenuItemException | MaximumTopUpLimitException | NotEnoughMoneyInBankomatException e) {
                LOGGER.error("an exception occurred -> " + e);
            }
        }
    }
}
