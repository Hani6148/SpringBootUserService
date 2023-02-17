package hub.userMicroservice.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value="User")
public class User {

	
	@Id
	private String email;
	private String password;
	private String fullName;
	private String phone;
	private String description;
	private List tutorialPosts = new ArrayList<String>();
	private List tutorialRequests = new ArrayList<String>();
	
	
	
}
