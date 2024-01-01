package HomeShopping.HomeShopping.repository;

import HomeShopping.HomeShopping.domain.MemberDTO;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberDTO save(MemberDTO member);
    Optional<MemberDTO> findByPassword(Long password);
    List<MemberDTO> findAll();
}
