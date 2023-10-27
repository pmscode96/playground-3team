package com.app.playground.controller;

import com.app.playground.domain.VO.UserVO;
import com.app.playground.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CheckController {
    private final UserService userService;

    @GetMapping("/check/phone")
    public ResponseEntity<Boolean> phoneNumberCheck(@RequestParam String phoneNumber) {
        log.info(phoneNumber);
        boolean exists = userService.userPhone(phoneNumber);
        log.info(String.valueOf(exists));
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/check/phoneNumberUpdate")
    public void phoneNumberUpdate(@RequestParam String phoneNumber, HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("user");
        userVO.setUserPhone(phoneNumber);
        userService.updateUserPhone(userVO);
    }

    @GetMapping("/check/email")
    public ResponseEntity<Boolean> checkUserEmail(@RequestParam String userEmail){
        boolean check = false;
        Optional<UserVO> foundUser = userService.getUser(userEmail);
        if (foundUser.isPresent()){
            check = true;
            return ResponseEntity.ok(check);
        }
        return ResponseEntity.ok(check);
    }
}
