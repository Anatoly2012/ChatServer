import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> usersInRoom = new ArrayList<User>();

    public ChatRoom(String roomName, List<User> usersInRoom) {
        this.roomName = roomName;
        this.usersInRoom = usersInRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<User> getUsersInRoom() {
        return usersInRoom;
    }

    public void setUsersInRoom(List<User> usersInRoom) {
        this.usersInRoom = usersInRoom;
    }

    public void addUser(User user) {
        usersInRoom.add(user);
    }

    public void removeUser(User user) {
        usersInRoom.remove(user);
    }

    public synchronized User findUserInRoom(String username) {
        for (User user : usersInRoom) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
