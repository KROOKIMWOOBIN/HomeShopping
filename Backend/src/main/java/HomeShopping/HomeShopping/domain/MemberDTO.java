package HomeShopping.HomeShopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor; // 기본 생성자를 자동 생성
import lombok.ToString; // 객체의 문자열 표현을 반환하는데 사용

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO { // 회원 정보를 필드로 정의
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
