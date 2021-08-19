package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
@WebServlet("/")
public class HomeServlet extends HttpServlet {

	//doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(new Greeting("Hello API"));

		resp.getWriter().print(jsonInString);	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
	//read query parameters
	//write the output in response object
			
	
}

	//service

class Greeting {
	private String message;

	public Greeting() {
		super();
	}

	public Greeting(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
}