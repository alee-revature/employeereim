package manager;

import java.util.List;

import common.model.Request;
import dao.RequestDao;
import dao.RequestDaoImpl;

public class RequestManager {

	private RequestDao dao = new RequestDaoImpl();
	
	public RequestManager() {
	}
	
	public void create(Request request) {
		dao.create(request);
	}
	
	public List<Request> findAll() {
		return dao.findAll();
	}

	public static void main(String[] args) {
		List<Request> requests = new RequestManager().findAll();
		System.out.println(requests);
	}

	public Request findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}
}
