package com.junjunguo.one2many.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This file is part of one2many.
 * <p/>
 * one user can have many tags, but a tag can only have one user
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 25/10/15.
 */

@Entity
@Table(name = "USER")
public class User {

    @Column(name = "NAME",
            nullable = false,
            columnDefinition = "varchar(128)")
    private String name;
    @Id
    @Column(name = "EMAIL",
            nullable = false,
            columnDefinition = "varchar(128)")
    private String email;
    @Column(name = "PASSWORD",
            nullable = false,
            columnDefinition = "varchar(128)")
    private String password;
    @Column(name = "COUNTRY",
            nullable = true,
            columnDefinition = "varchar(128)")
    private String country;
    @Column(name = "BIRTH",
            nullable = true,
            columnDefinition = "date")
    private Date   birth;
    @Column(name = "REGISTEREDTIME",
            nullable = false,
            columnDefinition = "datetime")
    private Date   registeredTime;

    @OneToMany(cascade = {CascadeType.ALL},
               targetEntity = Tag.class)
    @JoinColumn(name = "USER_EMAIL")
    private List<Tag> tags = new ArrayList<Tag>();

    public User(String name, String email, String country, String password) {
        this(name, email, country, password, Calendar.getInstance().getTime(),
                Calendar.getInstance().getTime());
    }

    public User(String name, String email, String password) {
        this(name, email, "", password);
    }

    public User(String name, String email, String country, String password, Date birth) {
        this(name, email, country, password, birth, Calendar.getInstance().getTime());
    }

    public User(String name, String email, String country, String password, Date birth,
            Date registeredtime) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.password = password;
        this.birth = birth;
        this.registeredTime = registeredtime;
    }

    public User() {
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addTagLabel(String label) {

        tags.add(new Tag(label));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    @Override
    public String toString() {
        return "User [name=" + name +
               ", email='" + email +
               ", country='" + country +
               ", password='" + password +
               ", birth=" + birth.toString() +
               ", registeredTime=" + registeredTime.toString() +
               ", tags=" + tags.toString() +
               "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getName().equals(user.getName())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getCountry() != null ? !getCountry().equals(user.getCountry()) : user.getCountry() != null) return false;
        if (getBirth() != null ? !getBirth().equals(user.getBirth()) : user.getBirth() != null) return false;
        return getRegisteredTime().equals(user.getRegisteredTime());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getBirth() != null ? getBirth().hashCode() : 0);
        return result;
    }
}

