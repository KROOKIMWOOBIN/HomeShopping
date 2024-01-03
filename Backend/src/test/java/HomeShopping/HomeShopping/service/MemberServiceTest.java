package HomeShopping.HomeShopping.service;

import HomeShopping.HomeShopping.domain.Member;
import HomeShopping.HomeShopping.repository.DataJpaMemberRepository;
import HomeShopping.HomeShopping.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void join() {
        Member member = new Member();
        member.setEmail("1");
        member.setPassword("1");
        member.setName("1");
        memberService.join(member);
    }

}
