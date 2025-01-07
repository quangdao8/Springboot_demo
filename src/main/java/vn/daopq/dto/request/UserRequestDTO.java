package vn.daopq.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import vn.daopq.util.*;

import java.io.Serializable;
import java.time.LocalDate;

import static vn.daopq.util.Gender.*;

public class UserRequestDTO implements Serializable {
    @NotBlank(message = "firstName must be not blank")
    private String firstname;
    @NotNull(message = "lastName must be not null")
    private String lastname;
    @Email(message = "Email invalid format")
    private String email;


    @PhoneNumber
    private String phone;

    @NotNull(message = "dateOfBirth must be not null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dateOfBirth;

    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus userStatus;

    @GenderSubset(anyOf = {MALE, FEMALE})
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }



    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserRequestDTO(String phone, String email, String lastname, String firstname) {
        this.phone = phone;
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public void setFirstname(@NotBlank(message = "firstName must be not blank") String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(@NotNull(message = "lastName must be not null") String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(@Email(message = "Email invalid format") String email) {
        this.email = email;
    }

    public void setPhone(@Pattern(regexp = "^\\d{10}$", message = "phone invalid format") String phone) {
        this.phone = phone;
    }

    public @NotNull(message = "dateOfBirth must be not null") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "dateOfBirth must be not null") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
