package com.ll.demo03.domain.member.member.controller;

import com.ll.demo03.domain.member.member.entity.Member;
import com.ll.demo03.domain.member.member.service.MemberService;
import com.ll.demo03.global.exceptions.GlobalException;
import com.ll.demo03.global.rsData.RsData;
import com.ll.demo03.standard.dto.util.Ut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    @ResponseBody
    public RsData<Member> join(
        String username, String password, String nickname
            ){
        if (Ut.str.isBlank(username)) {
            throw new GlobalException("400-1", "username(을)를 입력해주세요.");
        }
        if (Ut.str.isBlank(password)) {
            throw new GlobalException("400-2", "password(을)를 입력해주세요.");
        }
        if (Ut.str.isBlank(nickname)) {
            throw new GlobalException("400-3", "nickname(을)를 입력해주세요.");
        }
        return memberService.join(username, password, nickname);
    }
    @GetMapping("/testThrowIllegalArgumentException")
    @ResponseBody
    public RsData<Member> testThrowIllegalArgumentException(){
        throw new IllegalArgumentException("IllegalArgumentException 발생!");
    }
}
