package com.example.Dividend.web;

import com.example.Dividend.model.Auth;
import com.example.Dividend.security.TokenProvider;
import com.example.Dividend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    // 회원가입을 위한 API
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Auth.SingUp request) {
        var result = this.memberService.register(request);
        return null;
    }

    // 로그인 API
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody Auth.SingIn request) {
        var member = this.memberService.authenticate(request);
        // 인증이 되었다면 토큰을 생성하여 반환
        var token = this.tokenProvider.generateToken(member.getUsername(), member.getRoles());
        log.info("user login -> " + request.getUsername());
        return ResponseEntity.ok(token);
    }
}
