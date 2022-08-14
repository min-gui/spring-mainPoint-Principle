package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "min", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "aa", 5000);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(4000);

    }
}