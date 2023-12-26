package com.member;

import com.member.MemberDTO;
import com.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 해당 클래스가 컨트롤러임을 알리고 bean으로 등록하기 위함
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/")
    public String Home() {
        return "home";
    }

    @GetMapping("/MemberNew")
    public String createMemberForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(MemberDTO memberDTO) {
        Long memberId = memberService.join(memberDTO);
        return "home";
    }
}

/*
@RequiredArgsConstructor

1.  생성자 자동 생성: @RequiredArgsConstructor는 클래스의 필드를 기반으로 생성자를 자동으로 생성해줍니다.
    이를 통해 개발자는 생성자를 직접 작성하는 번거로움을 줄일 수 있습니다.
    필드의 개수나 타입이 변경되더라도 롬복이 자동으로 생성자를 갱신해주기 때문에 유지 보수성이 향상됩니다.

2.  불변 객체 생성: @RequiredArgsConstructor는 주로 불변(immutable) 객체를 생성할 때 유용합니다.
    final 키워드나 @NonNull 어노테이션을 사용하여 필드를 선언하고, 롬복의 @RequiredArgsConstructor를 적용하면 해당 필드들을 가지고 생성자를 자동으로 생성해줍니다.
    이를 통해 객체의 상태가 생성 후에 변경되지 않도록 보장할 수 있습니다.

3.  의존성 주입(Dependency Injection): @RequiredArgsConstructor를 사용하면 의존성 주입(Dependency Injection)을 간편하게 구현할 수 있습니다.
    필드를 final로 선언하고 @NonNull 어노테이션을 사용하면 롬복이 해당 필드를 가지고 생성자를 생성해줍니다.
    이를 활용하여 의존성 주입 프레임워크에서 자동으로 필요한 의존성을 주입받을 수 있습니다.

4.  코드 가독성 향상: 롬복의 @RequiredArgsConstructor를 사용하면 생성자 관련된 반복적이고 번거로운 작업을 줄일 수 있습니다.
    이를 통해 코드의 가독성을 향상시킬 수 있습니다. 개발자는 필드만 선언하고 롬복이 생성자를 자동으로 생성해주기 때문에,
    생성자 작성에 필요한 코드 양이 줄어들어 더 간결하고 명확한 코드를 작성할 수 있습니다.
 */