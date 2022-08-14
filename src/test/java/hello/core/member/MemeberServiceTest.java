package hello.core.member;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemeberServiceTest {

    private MemeberService memeberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memeberService.join(member);
        Member findMember = memeberService.findMember(member.getId());

        //then
        assertThat(member).isEqualTo(findMember);

    }

}