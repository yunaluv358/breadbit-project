package com.bread.web.user;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Component
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no") private Long userNo;
    @Column(name = "user_id", nullable = false ) private String userId;
    @Column(name = "password", nullable = false) private String password;
    @Column(name = "name", nullable = false) private String name;
    @Column(name = "phone", nullable = false) private String phone;
    @Column(name = "email", nullable = false) private String email;
    @Column(name = "sales") private String sales;
    @Column(name = "addr") private String addr;
    @Column(name = "detail_addr") private String detailAddr;

    @Builder
    public User(String userId, String password, String name, String phone, String email,String sales,String addr,String detailAddr){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.sales = sales;
        this.addr = addr;
        this.detailAddr = detailAddr;
    }


}
