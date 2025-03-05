package com.example.miniproject.service;

import com.example.miniproject.constant.Role;
import com.example.miniproject.dto.MemberDTO;
import com.example.miniproject.entity.Member;
import com.example.miniproject.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService , UserDetailsService {
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private void validMemberDupl(String email){
        Member member = memberRepository.findByEmail(email);
        if(member!=null){
            throw new IllegalStateException("이미 등록된 회원입니다.");
        }
    }

    @Override
    public MemberDTO register(MemberDTO memberDTO) {
        /*1. 이메일로 가입 여부 확인한다.*/
        validMemberDupl(memberDTO.getEmail());

        /*2. DTO 변환*/
        Member member = modelMapper.map(memberDTO,Member.class);

        /*3. 비밀번호 암호화*/
        member.setPsw(passwordEncoder.encode(member.getPsw()));

//        /*4. todo 일단 지금 권한은 ADMIN*/
//        member.setRole(Role.ADMIN);

        /*5. 저장*/
        member = memberRepository.save(member);

        /*6. 반환*/
        return modelMapper.map(member,MemberDTO.class);
    }

    @Override
    public MemberDTO update(MemberDTO memberDTO) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member= memberRepository.findByEmail(email);
        if(member==null){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        /*확인용?*/
        String role = "";
        if(member.getRole().name().equals(Role.ADMIN.name())){
            log.info("관리자 "+member.getEmail()+" 로그인 시도");
            role = member.getRole().name();
        }else{
            log.info("일반 회원 "+member.getEmail()+" 로그인 시도");
            role = member.getRole().name();
        }

        UserDetails user = User.builder().username(member.getEmail())
                .password(member.getPsw())
                .roles(role).build();
        return user;
    }
}
