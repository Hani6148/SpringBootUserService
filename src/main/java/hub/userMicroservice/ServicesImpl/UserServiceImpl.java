package hub.userMicroservice.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hub.userMicroservice.Model.User;
import hub.userMicroservice.Repository.UserRepo;
import hub.userMicroservice.Services.UserService;
import hub.userMicroservice.dto.UserCreationRequest;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(UserCreationRequest user) {
		User myUser = User.builder()
				.email(user.getEmail())
				.fullName(user.getFullName())
				.password(user.getPassword())
				.phone(user.getPhone())
				.build();
	     return userRepo.saveIfNotExists(myUser);
		
	}

	@Override
	public List<User> listAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub

	}
	@Override
	public void deleteUser(String email) throws Exception {
		
		userRepo.deleteUserByEmailIfExist(email);
	}
	

}
