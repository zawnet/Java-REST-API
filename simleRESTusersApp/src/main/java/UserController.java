import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

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
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String post(@FormParam("name") String name){
        System.out.println(name);
     return "Server says hello "+name;
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(@FormParam("id") int id,
                        @FormParam("name") String name,
                        @FormParam("password") String password,
                        @FormParam("email") String email) {
        User user = new User();
        try {
            user = new User(id, name, password, email);
            UserDAO.addUser(user);
            System.out.println(user.toString());
        } catch (InvalidParameterException e) {
            e.getMessage();

        }
        return user;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    public String updateUserEmail(@PathParam("id") int id,@PathParam("email") String email){
        UserDAO.updateUserEmail(id,email);
        return "email updated";
    }


}
