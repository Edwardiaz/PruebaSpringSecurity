package com.ws.dao;

import org.hibernate.Session;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ws.Entities.Category;
import com.ws.Entities.Optionss;
import com.ws.Entities.Products;
import com.ws.Entities.Role;
import com.ws.Entities.RoleOptions;
import com.ws.Entities.Settings;
import com.ws.Entities.Users;
import com.ws.Entities.UsersRole;

import com.ws.configuration.HibernateUtil;

@Repository
public class DaoByIdImpl implements IByIdDao {

	@Override
	public Optionss getOptionssById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Optionss.class, new Long(id));
		}
	}

	@Override
	public Role getRoleById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Role.class, new Long(id));
		}
	}

	@Override
	public RoleOptions getRoleOptionsById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(RoleOptions.class, new Long(id));
		}
	}

	@Override
	public Users getUsersById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Users.class, new Long(id));
		}
	}

	@Override
	public UsersRole getUsersRoleById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(UsersRole.class, new Long(id));
		}
	}

	@Override
	public Products getProductsById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Products.class, new Long(id));
		}
	}

	@Override
	public Category getCategoryById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Category.class, new Long(id));
		}
	}

	@Override
	public Settings getSettingsById(Long id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Settings.class, new Long(id));
		}
	}

//	@Override
//	public Users loginUsers(Users u) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			return session.createQuery("from Users WHERE users = :us AND password = :p", Users.class).setParameter("us", u.getUsers()).setParameter("p", u.getPassword()).getSingleResult();
//		}
//	}

	@Override
	public Users loginUsers(Users u) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Users WHERE users = :us AND password = :p", Users.class).setParameter("us", u.getUsers()).setParameter("p", u.getPassword()).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}

@Override
public Users loginSite(Users u) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		return session.createQuery("from Users WHERE users = :us AND password = :p", Users.class).setParameter("us", u.getUsers()).setParameter("p", u.getPassword()).getSingleResult();
		//return session.createQuery("from Users WHERE idUsers = :us", Users.class).setParameter("us", u.getIdUsers()).getResultList();
	}catch(Exception e) {
		return null;
	}
}
	
	
}
