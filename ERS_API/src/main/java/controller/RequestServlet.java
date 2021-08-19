package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.model.Request;
import common.util.AppConstants;
import common.util.HttpUtil;
import manager.RequestManager;

@WebServlet("/requests/*")
public class RequestServlet extends HttpServlet {

	private RequestManager manager = new RequestManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jsonInString = null;
		ObjectMapper mapper = new ObjectMapper();

		String[] pathVariables = HttpUtil.getPathVariables(req);
		
		if(pathVariables == null || pathVariables.length == 0) {
			//get data from back-end
			List<Request> requests = manager.findAll();
			//transform java object to JSON string
			jsonInString = mapper.writeValueAsString(requests);
		} 
		// GET /requests/:id
		// fetch individual request ticket item
		if(pathVariables != null && pathVariables.length == 2) {
			//get data from back-end
			int id = Integer.parseInt(pathVariables[1]);
			Request request = manager.findById(id);
			//transform java object to JSON string
			if(request != null)
				jsonInString = mapper.writeValueAsString(request);
			else
				jsonInString = HttpUtil.getErrorMessage("No Record Found");
		}
		
		//send success response to client
		resp.getWriter().print(jsonInString);
		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);
		resp.setStatus(AppConstants.HTTP_OK);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//get JSON data from HTTP body
			ObjectMapper mapper = new ObjectMapper();
			Request request = mapper.readValue(HttpUtil.getJSONData(req), Request.class);
			//persist data to back-end
			manager.create(request);
			//send success response to client
			String jsonResponse = mapper.writeValueAsString(request);
			resp.getWriter().print(jsonResponse);
			resp.setStatus(AppConstants.HTTP_OK);
		} catch (Exception e) {
			//send failure response to client
			resp.getWriter().print(HttpUtil.getErrorMessage(e.getMessage()));
			resp.setStatus(AppConstants.HTTP_ERROR);
		}

		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] pathVariables = HttpUtil.getPathVariables(req);
		// GET /requests/:id
		// fetch individual menu item
		if(pathVariables != null && pathVariables.length == 2) {
			//get data from back-end
			int id = Integer.parseInt(pathVariables[1]);
			manager.delete(id);
			resp.setStatus(AppConstants.HTTP_OK);
		}
	}
}
