package com.springboot.demo.domain;

import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

//import  org.springframework.data.annotation.Id;

/**
 * User class
 *
 * @author niezi
 * @date 2017/11/15
 */
@Entity
@Table(name="user")
public class User implements Serializable {
//    @ApiModelProperty(notes = "id")
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private  String id;
    @ApiModelProperty(notes = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    @ApiModelProperty(notes = "用户名称")
    private  String name;
    private  String password;
    @ApiModelProperty(notes = "用户地址")
    private  String address;
    @ApiModelProperty(notes = "年龄")
    private  int age;
    @ApiModelProperty(notes = "邮箱地址")
    private  String email;
    @ApiModelProperty(notes = "描述")
    private  String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (uuid != null ? !uuid.equals(user.uuid) : user.uuid != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return desc != null ? desc.equals(user.desc) : user.desc == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }
}
