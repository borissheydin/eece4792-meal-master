package com.app.eece4792mealmaster.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class User {

  public User() {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;

  @ManyToMany(cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
  })
  @JoinTable(name = "follows",
          joinColumns = @JoinColumn(name = "following_id"),
          inverseJoinColumns = @JoinColumn(name = "follower_id")
  )
  private Set<User> followers = new HashSet<>();

  @ManyToMany(mappedBy = "followers")
  private Set<User> following = new HashSet<>();


  @Transient
  public String getFullName() {
    return String.format("%s %s", this.firstName, this.lastName);
  }

  public void follow(User user) {
    this.following.add(user);
    user.getFollowers().add(this);
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<User> getFollowers() {
    return followers;
  }

  public void setFollowers(Set<User> followers) {
    this.followers = followers;
  }

  public Set<User> getFollowing() {
    return following;
  }

  public void setFollowing(Set<User> following) {
    this.following = following;
  }
}
