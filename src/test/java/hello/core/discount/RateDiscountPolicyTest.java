package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP members have 10 percent discount!")
    void vipGetRateDiscount() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 1000);

        // then
        assertThat(discount).isEqualTo(100);
    }

    @Test
    @DisplayName("Basic members do not have rate discount!")
    void basicNotGetDiscount() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 1000);

        // then
        assertThat(discount).isEqualTo(0);
    }
}