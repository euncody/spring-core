package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

// 정액 할인 정책 구현체
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 고정 할인 금액 (1000원 할인)

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ // ENUM은 비교 연산자(==)로 비교 가능
            return discountFixAmount; // VIP 회원에게는 고정 할인 금액을 반환
        } else {
            return 0; // 일반 회원에게는 할인 없음
        }
    }
}
