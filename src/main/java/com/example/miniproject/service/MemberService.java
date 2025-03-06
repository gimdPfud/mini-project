package com.example.miniproject.service;

import com.example.miniproject.dto.MemberDTO;
import com.example.miniproject.dto.RequestPageDTO;
import com.example.miniproject.dto.ResponsePageDTO;

public interface MemberService {
    /*회원등록*/
    public MemberDTO register(MemberDTO memberDTO);

    /*회원수정*/
    public MemberDTO update(MemberDTO memberDTO);

    /*회원삭제...는없음?*/
    /*회원전부읽기*/
    public ResponsePageDTO<MemberDTO> memberList(String keyword, RequestPageDTO requestPageDTO);
}
