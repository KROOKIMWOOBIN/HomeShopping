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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional // 테스트 실행한 후 롤백을 함
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private DataJpaMemberRepository DataJpaMemberRepository;

    @Test
    public void 회원가입() {
        //given
        Member member = new Member();
        member.setEmail("1");
        member.setPassword("1");
        member.setName("1");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
    }
}
