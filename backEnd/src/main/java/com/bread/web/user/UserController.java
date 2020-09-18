package com.bread.web.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController @AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final  User user;

    @GetMapping("/csv")
    public void readCsv() {
        userService.readCsv();
    }

    // 로그인
    @PostMapping("/signIn")
    public ResponseEntity<User> signIn(@RequestBody User user) {
        Optional<User> findByUserId = userRepository.findByUserId(user.getUserId());
        if (findByUserId.isPresent()) {
            User userLogin = findByUserId.get();
            if (user.getPassword().equals(userLogin.getPassword())) {
                return ResponseEntity.ok(userLogin);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // 회원가입
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "님의 회원가입을 축하합니다";
    }

    // 회원목록 출력
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    // 회원 정보 변경
    @PatchMapping("/changeInfo/{userId}")
    public ResponseEntity<User> changeInfo( @RequestBody User user){
        Optional<User> updateUser = userRepository.findByUserId(user.getUserId());
        if (updateUser.isPresent()){
            updateUser.ifPresent(selectUser ->{
                selectUser.setName(user.getName());
                selectUser.setUserId(user.getUserId());
                selectUser.setPassword(user.getPassword());
                selectUser.setEmail(user.getEmail());
                selectUser.setPhone(user.getPhone());
                selectUser.setAddr(user.getAddr());
                selectUser.setDetailAddr(user.getDetailAddr());
                userRepository.save(selectUser);
            });
            return ResponseEntity.ok(updateUser.get());
        } else {
            System.out.println("정보수정 실패 재시도 바랍니다");

            return ResponseEntity.notFound().build();
        }
    }
    // 회원삭제
    @PostMapping("/delete")
    public Optional<User> userDelete(@RequestBody User user){
        Optional<User> userCancle = userRepository.findByUserId(user.getUserId());
        userCancle.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });
        return userCancle;
    }
    // 회원 정보 수정
    @PostMapping("/allUpdate")
    public void allUpdate(@RequestBody List<User> user){
        userRepository.saveAll(user);
    }
    // 유저 차트 데이터

    @GetMapping("/data/{name}")
    public Map<String,Integer> userChart(@PathVariable String name){
     return userService.chartData(name);
    }

    //아이디 찾기
    @GetMapping("/findId")
    public ResponseEntity<User> findId(@RequestParam String name, String phone) {
        Optional<User> findId = userRepository.findAllByNameAndPhone(name,phone);
        System.out.println(findId);
        if(findId.isPresent()) {
            return ResponseEntity.ok(findId.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    //비밀번호 찾기
    @GetMapping("/findPw")
    public ResponseEntity<User> findPw(@RequestParam String userId, String name, String phone) {
        System.out.println(name);
        System.out.println(phone);
        System.out.println(userId);
        Optional<User> findPw = userRepository.findAllByUserIdAndNameAndPhone(userId,name,phone);
        System.out.println(findPw);
        if(findPw.isPresent()) {
            return ResponseEntity.ok(findPw.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}