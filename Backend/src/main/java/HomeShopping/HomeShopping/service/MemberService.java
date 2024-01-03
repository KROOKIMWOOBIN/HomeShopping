package HomeShopping.HomeShopping.service;

import HomeShopping.HomeShopping.repository.DataJpaMemberRepository ;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import HomeShopping.HomeShopping.domain.Member;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final DataJpaMemberRepository  memberRepository;

    @Autowired
    public MemberService(DataJpaMemberRepository  memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member){
        ((CrudRepository<Member, Long>) memberRepository).save(member);
        return member.getId();
    }

    // 중복 회원가입 확인
    private void validateDuplicateMember(Member member){
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    
    //회원 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
