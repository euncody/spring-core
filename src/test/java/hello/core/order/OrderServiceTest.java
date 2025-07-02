package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach // 테스트가 실행되기 전에 매번 실행되는 메서드
    public void beforeEach() {
        // AppConfig를 통해 MemberService를 생성
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getMemberId()).isEqualTo(memberId);
        // Assertions는 테스트 코드에서 기대하는 값과 실제 값이 일치하는지 확인하는 역할
        // 같으면 테스트 성공 (pass).
        // 다르면 테스트가 실패 (fail) 하며, JUnit이 실패로 보고
    }
}
