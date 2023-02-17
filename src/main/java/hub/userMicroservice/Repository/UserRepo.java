package hub.userMicroservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import hub.userMicroservice.Model.User;
@Repository
public interface UserRepo extends MongoRepository<User, String> {

	  User findByEmail(String email);
	  void deleteUserByEmail(String email);
	  default User saveIfNotExists(User user) {
	        User existingUser = findByEmail(user.getEmail());
	        if (existingUser == null) {
	            return save(user);
	        }
	        return null;
	    }
	  default void deleteUserByEmailIfExist(String email) throws Exception {
		  User existingUser = findByEmail(email);
		  if (existingUser == null) {
	            throw new Exception();
	        }
		  deleteUserByEmail(email);
	  }
}
