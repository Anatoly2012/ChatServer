import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static final UserList userList = new UserList();
    private final List<User> users = new ArrayList<User>();

    private UserList() {
        File file = new File("C:\\Exemples\\Pro\\ChatJEE\\ChatServer\\users.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (String string; (string = br.readLine()) != null; ) {
                String[] user = string.split(":");
                addUserToList(user[0], user[1]);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private boolean addUserToList(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        users.add(new User(username, password));
        return true;
    }

    public static UserList getInstance() {
        return userList;
    }

    public synchronized void add(User user) {
        users.add(user);
    }

    public synchronized User find (String login){
        for (User user: users) {
            if (user.getUsername().equals(login)){
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "UserList{" + users + '}';
    }
}
