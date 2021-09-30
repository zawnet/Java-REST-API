import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    static List<User> users = new ArrayList<>();
    public static List<User> getUsers(){

        //users.add(new User(1,"Jan Kowalski","dupa","test@gmail.com"));
        //users.add(new User(2,"Tomasz Nowak","dupa","test@gmail.com"));
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void updateUserEmail(int id, String email) {
        users.get(id).setEmail(email);
    }
}
