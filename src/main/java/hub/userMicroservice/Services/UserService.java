package hub.userMicroservice.Services;

import java.util.List;

import hub.userMicroservice.Model.User;
import hub.userMicroservice.dto.UserCreationRequest;

public interface UserService {

	public User createUser(UserCreationRequest user);
	public List<User> listAllUsers();
	public void UpdateUser(User user);
	public void deleteUser(String email) throws Exception;
	
}
