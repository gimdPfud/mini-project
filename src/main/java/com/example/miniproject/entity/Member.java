package com.example.miniproject.entity;

import com.example.miniproject.constant.Gender;
import com.example.miniproject.constant.Quitstatus;
import com.example.miniproject.constant.Role;
import com.example.miniproject.entity.base.BaseTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Member extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;         //번호, pk

    @Column(nullable = false, length = 30)
    private	String	name;     //회원 이름

    @Column(nullable = false, unique = true)
    private	String	email;    //회원 이메일

    @Column(nullable = false)
    @Size(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 작성해주세요.")
    private	String	psw;      //회원 비밀번호

    private	String	addr;     //회원 주소
    private	String	addr_detail;//회원 상세주소

    @Column(unique = true)      //01012345678 형식으로 저장할 예정.
    private String	tel;      //회원 전화번호

    @Enumerated(EnumType.STRING)
    private Gender gender;    //회원 성별



    private	String	note;     //관리자용메모

    private	LocalDateTime quitdate;//탈퇴신청날짜

    @Enumerated(EnumType.STRING)
    private Role role;        //등급

    @Enumerated(EnumType.STRING)
    private Quitstatus quitstatus;  //탈퇴여부

}