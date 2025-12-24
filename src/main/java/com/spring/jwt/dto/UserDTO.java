
package com.spring.jwt.dto;

import com.spring.jwt.entity.Role;
import com.spring.jwt.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Schema(description = "userId of User", example = "10011")
    private Long userId;

    @Schema(description = "Email of User", example = "example@example.com")
    private String email;

    @Schema(description = "Mobile Number of the customer", example = "9822222212")
    private Long mobileNumber;

    @Schema(description = "Password to create an account", example = "Pass@1234")
    private String password;
    private Set<String> roles;

    private String role;

    public UserDTO(User user) {
        this.email = user.getEmail();
//        this.address = user.getAddress();
//        this.firstName = user.getFirstName();
//        this.lastName = user.getLastName();
        this.mobileNumber = user.getMobileNumber();
        this.userId = user.getUser_id();

        if (user.getRoles() != null) {
            this.roles = user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.toSet());
        }
    }

    public static UserDTO fromEntity(User user) {
        if (user == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setEmail(user.getEmail());
        dto.setMobileNumber(user.getMobileNumber());
//        dto.setFirstName(user.getFirstName());
//        dto.setLastName(user.getLastName());
//        dto.setAddress(user.getAddress());
        dto.setUserId(user.getUser_id());

        if (user.getRoles() != null) {
            dto.setRoles(user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.toSet()));
        }

        return dto;
    }
}
