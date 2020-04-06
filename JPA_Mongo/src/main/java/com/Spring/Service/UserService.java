package com.Spring.Service;

import java.util.Optional;
import com.Spring.Modal.UserDetail;

public interface UserService {
	public void createUser(UserDetail user);

	public Optional<UserDetail> findEmployeeByUsername(String username);
}
