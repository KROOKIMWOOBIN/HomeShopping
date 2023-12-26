package com.member;

import com.member.MemberDomain;
import com.member.MemberDTO;
import com.member.MemberRepository;
import com.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(MemberDTO memberDTO) {
        MemberDomain member = MemberDomain.builder()
                .email(memberDTO.getEmail())
                .username(memberDTO.getUsername())
                .password(memberDTO.getPassword())
                .build();

        return memberRepository.save(member).getId();
    }
}
