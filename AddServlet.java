//package ua.kiev.prog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	private MessageList msgList = MessageList.getInstance();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		Message msg = Message.fromJSON(br.readLine());
		if (msg != null)
			msgList.add(msg);
		else
			resp.setStatus(400); // Bad request
	}
}
