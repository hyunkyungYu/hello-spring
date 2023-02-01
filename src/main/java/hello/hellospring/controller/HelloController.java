package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return  "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    // body 부에 이 data 를 직접 넣어주겟다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // hello string / hello kim ...
        // 템플릿 엔진과의 차이점. 이 문자가 그대로 들어감. html 태그가 없음.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        // complete Current Statement : ctrl + shift + enter
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json으로 반환하는게 기본임.
    }
    static class Hello {
        private String name;
        // 자바 빈 표준 방식 or 프로퍼티 접근 방식
        // getter and setter : alt + insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
