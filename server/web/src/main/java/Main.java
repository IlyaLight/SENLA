import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.api.model.UserValidate;

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
