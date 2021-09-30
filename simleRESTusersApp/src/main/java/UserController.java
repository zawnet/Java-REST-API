import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Path("users")
public class UserController {
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(){
        ObjectMapper mapper = new ObjectMapper();
        String value = "";
        mapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        try {
            value =  mapper.writeValueAsString(UserDAO.getUsers());
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        return value;
    }

}
