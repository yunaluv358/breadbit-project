package com.bread.web.dummyUser;

import com.bread.web.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyUserController {
    @Autowired
    DummyUserService dummyUserService;

    @PostMapping("/user-generator")
    public ResponseEntity<List<User>> createRandomUser() {
        List<User> randomUserList = dummyUserService.createDummyUser();
        return ResponseEntity.ok(randomUserList);
    }
}