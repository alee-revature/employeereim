package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.model.User;
import common.util.DBUtil;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
	}

	@Override
	public void create(User user) {
		Session session = DBUtil.getInstance().getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;// new RuntimeException(e.getCause());
		}

		session.close();
	}

	@Override
	public User getUser(String username, String password) {
		Session session = DBUtil.getInstance().getSession();

		Query query = session.createQuery("FROM common.model.User where username = :username and password = :password");
		query.setString("username", username);
		query.setString("password", password);

		User user = (User) query.uniqueResult();

		session.close();
		return user;
	}

}
