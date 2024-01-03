package HomeShopping.HomeShopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import HomeShopping.HomeShopping.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

}
