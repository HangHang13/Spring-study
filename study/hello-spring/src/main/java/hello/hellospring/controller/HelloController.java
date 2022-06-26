package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("hello") //hello 가 들어오면 이것이 실행됨
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";
    }
}
