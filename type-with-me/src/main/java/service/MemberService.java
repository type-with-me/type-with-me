package service;

import repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository=new MemberRepository();     // MemberService 객체 생성과 동시에 MemberRepository 객체 생성

    public MemberService() {
    }
}
