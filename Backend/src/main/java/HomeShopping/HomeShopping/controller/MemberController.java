package HomeShopping.HomeShopping.controller;


import HomeShopping.HomeShopping.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private MemberService memberService;

    @GetMapping ("/members/save")
    public String saveForm() {
        return "save";
    }

}
