package hub.userMicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {
	private String email;
	private String password;
	private String fullName;
	private String phone;
}
