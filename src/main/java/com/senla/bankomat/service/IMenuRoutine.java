package com.senla.bankomat.service;

import com.senla.bankomat.constants.MenuItems;
import com.senla.bankomat.exceptions.*;

import java.io.IOException;
import java.util.Map;

public interface IMenuRoutine {
    void menuCommandExecute(Map<Integer, MenuItems> itemsHashMap) throws
            InputErrorException, NoSuchClientException, IOException, NoSuchCardException, AccountBlockException,
            ServiceMissingException, NotSufficientBalanceException, MissingMenuItemException, MaximumTopUpLimitException, NotEnoughMoneyInBankomatException;
}
