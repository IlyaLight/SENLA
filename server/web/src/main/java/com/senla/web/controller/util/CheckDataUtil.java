package com.senla.web.controller.util;

import com.senla.api.exception.IncompleteDataException;
import com.senla.api.model.Car;
import com.senla.api.model.Login;
import com.senla.api.model.Person;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/** checks and prepares data **/

public class CheckDataUtil {

    static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    static Validator validator = factory.getValidator();

    public static Validator getValidator(){
        return validator;
    }

    public static void createBuyerCheckData(Person person) throws IncompleteDataException{
        if ( person.getEmail() == null ||
                person.getLogin() == null ||
                person.getLogin().getLogin() == null||
                person.getLogin().getPassword() == null ){
            throw new IncompleteDataException();
        }
        person.setId(null);
        person.setStatus(Person.Status.BUYER);
        person.setActive(true);
        person.getLogin().setId(null);

    }

    public static void authenticationCheakData(Login login) throws IncompleteDataException {
        if (login.getPassword() == null || login.getLogin() == null) {
            throw new IncompleteDataException();
        }
    }

    public static void createCarCheckData(Car car) throws IncompleteDataException {
        if (car.getBrand() == null ||
                car.getModel() == null ||
                car.getTypeOfFuel() == null ||
                car.getYear() == null) {
            throw new IncompleteDataException();
        }
    }

    public static void updateCarCheckData(Car car) throws IncompleteDataException {
        if (car.getId() == null) {
            throw new IncompleteDataException();
        }
        createCarCheckData(car);
    }
}
