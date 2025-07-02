package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl();

    MemberService memberService;

    @BeforeEach // 테스트가 실행되기 전에 매번 실행되는 메서드
    public void beforeEach() {
        // AppConfig를 통해 MemberService를 생성
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService(); // AppConfig를 통해 MemberService를 생성
        // 위의 코드는 MemberServiceImpl을 직접 생성하는 것이 아니라, AppConfig를 통해 생성된 인스턴스를 사용
    }

    @Test
    void join() {
        // Given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // When
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // Then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
