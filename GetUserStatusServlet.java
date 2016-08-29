import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetUserStatusServlet extends HttpServlet {
    private MessageList messageList = MessageList.getInstance();
    private UserList userList = UserList.getInstance();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        Message m = Message.fromJSON(br.readLine());
        if (m != null && userList.find(m.getTo()) != null){
            m.setText(userList.find(m.getTo()).toString());
            m.setTo(m.getFrom());
            messageList.add(m);
        }
        else {
            resp.setStatus(400);
        }
    }
}
