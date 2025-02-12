package service;

import aggregate.Member;
import java.util.ArrayList;
import repository.MemberRepository;

public class MemberService {
    private final MemberRepository memberRepository=new MemberRepository();     // MemberService 객체 생성과 동시에 MemberRepository 객체 생성

    public MemberService() {
    }

    public void showAllMembers() {
        ArrayList<Member> members=null;
        members=memberRepository.selectAllMembers();
        for(Member member:members) {
            System.out.println(member);
        }
    }
}
