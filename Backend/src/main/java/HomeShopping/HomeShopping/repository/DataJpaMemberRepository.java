package HomeShopping.HomeShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import HomeShopping.HomeShopping.domain.Member;

import java.util.Optional;

public interface DataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByEmail(String email);
}
