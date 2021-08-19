package dao;

import java.util.List;

import common.model.Request;

public interface RequestDao {

	public void create(Request request);
	
	public List<Request> findAll();

	public Request findById(int id);

	public void delete(int id);

}
