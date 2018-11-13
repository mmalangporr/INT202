/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWProcess.model;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Kittisak
 */
@Entity
@Table(name = "users")
public class Users extends SerializableSerializer{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    
    @NotBlank
    private String fullName;
    
    @NotBlank
    private String userName;
    
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;
    
    @NotBlank
    private String address;
    
    @NotBlank
    private String phoneNumber;
    
    @NotBlank
    private String roleOfUser;
    
    @NotBlank
    private String image;
    
    @NotBlank
    private boolean loginStatus;

    @NotBlank
    private long customerId;
    
    @NotBlank
    private long sellerId;
    
    @NotBlank
    private long adminId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleOfUser() {
        return roleOfUser;
    }

    public void setRoleOfUser(String roleOfUser) {
        this.roleOfUser = roleOfUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", email=" + email + ", password=" + password + ", address=" + address + ", phoneNumber=" + phoneNumber + ", roleOfUser=" + roleOfUser + ", image=" + image + ", loginStatus=" + loginStatus + ", customerId=" + customerId + ", sellerId=" + sellerId + ", adminId=" + adminId + '}';
    }

    
}
