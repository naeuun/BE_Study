package com.ll.demo03.domain.member.member.service;

import com.ll.demo03.domain.member.member.entity.Member;
import com.ll.demo03.domain.member.member.repository.MemberRepository;
import com.ll.demo03.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService{
    private final MemberRepository memberRepository;

    public RsData<Member> join(String username, String password, String nickname) {
        /* findByUsername(username).ifPresent(m -> {
            throw new IllegalArgumentException("이미 사용중인 username 입니다.");
        }); */

        boolean present = findByUsername(username).isPresent();
        if (present) {
            return RsData.of("400-1", "이미 존재하는 아이디입니다.", Member.builder().build());
        }

        Member member = Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();

        memberRepository.save(member);
        return RsData.of("%s님 환영합니다.".formatted(nickname), member);
    }

    private Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}

