package hub.userMicroservice.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hub.userMicroservice.CustomExceptions.UserCreationException;
import hub.userMicroservice.Model.User;
import hub.userMicroservice.Services.UserService;
import hub.userMicroservice.dto.UserCreationRequest;

@RestController
@RequestMapping("/hub/user")
public class UserController {
	
	@Autowired
	UserService userSvc;
	
	@PostMapping("/create")
	public ResponseEntity<String> createUser (@RequestBody UserCreationRequest user) throws UserCreationException {
		
			if (userSvc.createUser(user)==null) {
				throw new UserCreationException("error creating user");
			}
			else
			{
			 return new ResponseEntity<>("User created successfully", HttpStatus.OK);
			}
			
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userSvc.listAllUsers();
	}
	
	@DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        try {
            userSvc.deleteUser(email);
        } catch (Exception e) {
            return new ResponseEntity<>("user doesn't not exist", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("User deleted successfully", HttpStatus.FOUND);
    }
	
	

}
