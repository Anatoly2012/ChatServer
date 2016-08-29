import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChatRoomServlet extends HttpServlet{
    private MessageList messageList = MessageList.getInstance();
    private ChatRoomList chatRoomList = ChatRoomList.getInstance();
    private UserList userList = UserList.getInstance();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        Message m = Message.fromJSON(br.readLine());

//        ChatRoom room = chatRoomList.chatRoomFind(m.getTo());
//        if (room == null){
//            chatRoomList.addChatRoom(new ChatRoom(m.getTo(), new ArrayList<User>()));
//        }
        if (chatRoomList.chatRoomFind(m.getTo()) == null){
            chatRoomList.addChatRoom(new ChatRoom(m.getTo(), new ArrayList<User>()));
        }
        ChatRoom room = chatRoomList.chatRoomFind(m.getTo());
        if (room.findUserInRoom(m.getFrom()) == null){
            room.addUser(userList.find(m.getFrom()));
        }
        for (User user : room.getUsersInRoom()) {
            Message message = new Message();
            message.setFrom(m.getFrom());
            message.setText(m.getText());
            message.setTo(user.getUsername());
            messageList.add(message);
        }
    }
}
