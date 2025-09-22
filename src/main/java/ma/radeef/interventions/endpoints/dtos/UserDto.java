package ma.radeef.interventions.endpoints.dtos;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private Long id;
	private String username;
	private String email;
	private String role;
    private String createdAt;
    private Date lastLogin;
    private String description;
    private String imageBase64; // Image encodée en Base64

}
