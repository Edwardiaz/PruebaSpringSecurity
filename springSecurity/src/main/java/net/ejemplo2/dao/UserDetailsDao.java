package net.ejemplo2.dao;

import net.ejemplo2.entity.User;

public interface UserDetailsDao {
	
	User findUserByUsername(String username);
	
}
