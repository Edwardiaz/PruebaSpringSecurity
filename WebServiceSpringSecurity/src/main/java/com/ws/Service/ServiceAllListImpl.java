package com.ws.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ws.dao.*;
import com.ws.Entities.*;

@Service
public class ServiceAllListImpl implements IAllListService {

	
	public ServiceAllListImpl() {
	}
	
	@Autowired
	@Qualifier(value = "listDao")
	private IAllListDao allList;
	
//	@Autowired
//	public ServiceAllListImpl(IAllListDao allList) {
//		this.allList = allList;
//	}
	
	@Override
	public List<Optionss> allOptionss() {
		return allList.allOptionss();
	}

	@Override
	public List<Role> allRole() {
		System.out.println("************ it entered");
		return allList.allRole();
	}

	@Override
	public List<RoleOptions> allRoleOptions() {
		return allList.allRoleOptions();
	}

	@Override
	public List<Users> allUsers() {
		return allList.allUsers();
	}

	@Override
	public List<Products> allProducts() {
		return allList.allProducts();
	}

	@Override
	public List<UsersRole> allUsersRole() {
		return allList.allUsersRole();
	}

	@Override
	public List<Category> allCategory() {
		return allList.allCategory();
	}

	@Override
	public List<Settings> allSettings() {
		return allList.allSettings();
	}

	@Override
	public List<UsersRole> loginSite(Users u) {
		return allList.loginSite(u);
	}
}
