package com.example.miniproject.repository;


import com.example.miniproject.entity.Member;
import com.example.miniproject.entity.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MemberSearchImpl extends QuerydslRepositorySupport implements MemberSearch{
    public MemberSearchImpl() {
        super(Member.class);
    }

    @Override
    public Page<Member> memberList(String keyword, Pageable pageable) {
        System.out.println("들어온 파라미터 : ");
        System.out.println(keyword);

        QMember member = QMember.member;
        JPQLQuery<Member> query = from(member);

        if ( keyword != null ){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(member.name.contains(keyword));
            booleanBuilder.or(member.email.contains(keyword));
            booleanBuilder.or(member.note.contains(keyword));
            query.where(booleanBuilder);
        }

        // 페이징 처리
        this.getQuerydsl().applyPagination(pageable, query);

        // 리스트
        List<Member> memberList = query.fetch();

        // 총 게시물
        Long count = query.fetchCount();

        return new PageImpl<>(memberList, pageable, count);
    }
}
