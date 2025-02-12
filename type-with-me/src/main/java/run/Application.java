package run;

import service.MemberService;

public class Application {
    private static final MemberService memberService = new MemberService();     // 프로그램 시작과 동시에 MemberService 객체 생성
    public static void main(String[] args) {
        memberService.showAllMembers();
    }
}
