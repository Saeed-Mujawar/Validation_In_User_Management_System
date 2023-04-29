package com.Geekster.UserManagementSystem.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotEmpty //or @NotEmpty(message = "why name is empty !!")
    private String userId;
    @NotNull
    private String name;

    @NotBlank
    private String address;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private String dob;
    @Email(regexp = "[A-Za-z]+[0-9]+@[a-z]+\\.com")
    private String email;
    @Size(min = 10, max = 12)
    @Pattern(regexp = "^[0-9]+$")
    private String phoneNumber;



}
