import java.util.ArrayList;
import java.util.List;

public class ChatRoomList {
    private static final ChatRoomList chatRoomList = new ChatRoomList();
    private final List<ChatRoom> list = new ArrayList<ChatRoom>();

    private ChatRoomList() {
    }

    public static ChatRoomList getInstance() {
        return chatRoomList;
    }

    public synchronized void addChatRoom(ChatRoom chatRoom) {
        list.add(chatRoom);
    }

    public synchronized ChatRoom chatRoomFind(String chatName) {
        for (ChatRoom chatroom : list) {
            if (chatroom.getRoomName().equals(chatName)) {
                return chatroom;
            }
        }
        return null;
    }
}
