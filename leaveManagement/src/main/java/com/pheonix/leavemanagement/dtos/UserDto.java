package com.pheonix.leavemanagement.dtos;

import com.pheonix.leavemanagement.models.User;
import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class UserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 339069682243497021L;
    @NotEmpty(message = Messages.REQUIRED_FIRST_NAME)
    @Size(max = 100, message = Messages.FIRST_NAME_MAX_SIZE)
    private String firstName;

    @NotEmpty(message = Messages.REQUIRED_LAST_NAME)
    @Size(max = 100, message = Messages.LAST_NAME_MAX_SIZE)
    private String lastName;

    private String email;

    private String password;

    private String username;

    @NotEmpty(message = Messages.REQUIRED_COUNTRY_CODE)
    @Size(max = 5, message = Messages.COUNTRY_CODE_MAX_SIZE)
    private String countryCode;

    @NotEmpty(message = Messages.REQUIRED_CONTACT_NUMBER)
    @Size(max = 10, message = Messages.CONTACT_NUMBER_MAX_SIZE)
    private String contactNumber;

    private String departmentId;

    private String designationId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDesignationId() {
        return designationId;
    }

    public void setDesignationId(String designationId) {
        this.designationId = designationId;
    }

    public User builduser() {
        User user = new User();
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setUsername(this.username.toLowerCase());
        user.setCountryCode(this.countryCode);
        user.setContactNumber(this.contactNumber);
        user.setDepartmentId(this.departmentId);
        user.setDesignationId(this.designationId);
        user.setUserStatus(true);
        return user;
    }
}
