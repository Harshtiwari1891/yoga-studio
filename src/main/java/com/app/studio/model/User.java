package com.app.studio.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity which is going to hold the User data
 *
 * @author malalanayake
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findByUserName", query = "select u from User u where u.username=:userName")})
@Table(name = "USER")
public class User {

    /**
     * Interface which is provide the name queries and parameters
     */
    public static interface Constants {

        public static final String NAME_QUERY_FIND_BY_USER_NAME = "findByUserName";
        public static final String PARAM_USER_NAME = "userName";
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private ArrayList<String> roles;
    private String firstName;
    private String lastName;
    private String sequrityQuestion;
    private String answer;

    public User(String username, String password, String firstName,
            String lastName, String sequrityQuestion, String answer) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sequrityQuestion = sequrityQuestion;
        this.answer = answer;
        this.roles = new ArrayList<String>();
    }

    public void addRole(String role) {
        this.roles.add(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

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

    public String getSequrityQuestion() {
        return sequrityQuestion;
    }

    public void setSequrityQuestion(String sequrityQuestion) {
        this.sequrityQuestion = sequrityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", "
                + "roles=" + roles + ", firstName=" + firstName + ", lastName=" + lastName + ","
                + " sequrityQuestion=" + sequrityQuestion + ", answer=" + answer + '}';
    }
}