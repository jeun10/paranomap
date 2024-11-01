package com.example.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity(name="USER_INFO")
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    
    private String userpw;
    
    @Column(unique = true)
    private String username;
    
    @Column(unique = true)
    private String useremail;

    @Builder
    public User(Long userId, String userpw, String username, String useremail) 
    {
        this.userId = userId;
        this.userpw = userpw;
        this.username = username;
        this.useremail = useremail;
    }

}
