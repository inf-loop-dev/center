package com.inf_loop_dev.center.domain.user;

import com.inf_loop_dev.center.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="\"user\"")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;



//    public User(String name, String email, String picture, Role role){
//        this.name = name;
//        this.email = email;
//        this.picture = picture;
//        this.role = role;
//    }

    public User update(String userName, String picture){
        this.name = userName;
        this.picture = picture;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
//    private String userId;
//    private String passwd;

}
