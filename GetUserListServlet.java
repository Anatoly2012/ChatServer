import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetUserListServlet extends HttpServlet {
    private UserList userList = UserList.getInstance();
    private MessageList messageList = MessageList.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        Message message = Message.fromJSON(br.readLine());

        if (message != null) {
            message.setTo(message.getFrom());
            message.setText(userList.toString());
            messageList.add(message);
        }
        else {
            response.setStatus(400);
        }
    }
}
