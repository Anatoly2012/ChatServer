import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginServlet extends HttpServlet {
    //    static final String LOGIN = "admin";
//    static final String PASSWORD = "admin";
    private UserList userList = UserList.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        Message message = Message.fromJSON(br.readLine());

        User user = userList.find(message.getFrom());
        if (user != null && user.getPassword().equals(message.getText())) {
            user.setStatus(true);
            response.setStatus(200);
        } else {
            response.setStatus(400);
        }
        //        if (message.getFrom().equals(LOGIN) && message.getText().equals(PASSWORD)) {
//            response.setStatus(200);
//        } else {
//            response.setStatus(400);
//        }
    }
}
