package HomeShopping.HomeShopping.repository;

import java.util.List;
import java.util.Optional;
import HomeShopping.HomeShopping.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    public Optional<Member> findByEmail(String email);
    List<Member> findAll();
}
