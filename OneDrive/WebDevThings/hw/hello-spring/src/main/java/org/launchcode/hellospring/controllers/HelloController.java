package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    public String language;



//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        if (name==null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "hello " + name ;
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='get'>" +
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "<option value = 'english'>English</option>" +
                "<option value = 'french'>French</option>" +
                "<option value = 'spanish'>Spanish</option>" +
                "<option value = 'dutch'>Dutch</option>" +
                "<option value = 'japanese'>Japanese</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage (String name, String language) {
        String greeting = "konicha";
        if (language.equals("english")) {
            greeting = "Hello ";
        } else if (language.equals("french")) {
            greeting = "Bonjour ";
        } else if (language.equals("spanish")) {
            greeting = "Hola ";
        } else if (language.equals("dutch")) {
            greeting = "Hallo ";
        } else if (language.equals("japanese")) {
            greeting = "Konnichiwa ";
        }
        return greeting + name;
    }

}
