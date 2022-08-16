package hello.core.order;

import hello.core.discount.DiscountPlicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPlicy discountPlicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPlicy discountPlicy) {
        this.memberRepository = memberRepository;
        this.discountPlicy = discountPlicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPlicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
