import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.UserValidate;
import com.senla.api.service.IUserService;
import com.senla.back.dao.api.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;


public class Main {


    public static void main(String[] args) {






        UserValidate validate = new UserValidate();
        validate.setId(1);
        validate.setLogin("root");
        validate.setPass("root");

        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonInString = mapper.writeValueAsString(validate);
            System.out.println(jsonInString);
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(validate);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
