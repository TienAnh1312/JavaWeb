package buitienanh.edu.vn.dao;

import java.util.List;

import org.hibernate.Session;

import buitienanh.edu.vn.entity.Product;
import buitienanh.edu.vn.ultil.HibernateUtil;


public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> getallproduct() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Product> list = session.createQuery("form product").list();
			session.getTransaction().commit();
			session.close();
			return list;
		}catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public Product getProductById(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Product product = (Product)session.createQuery("form Product where MaSP = :maSp").setParameter("maSp", id).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return product;
		}catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertProduct(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete form Product where MaSP = :maSp").setParameter("maSp", id).executeUpdate();
			session.getTransaction().commit();
			session.close();
			if(res>0)
				return true;
		}catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

}
