import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"Jan Kowalski","dupa","test@gmail.com"));
        users.add(new User(2,"Tomasz Nowak","dupa","test@gmail.com"));
        return users;
    }
}
