package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

    public String language;



//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String thegreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", thegreeting);
        return "hello";
    }

//    @RequestMapping(method = {RequestMethod.GET}, value = "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
//        if (name==null) {
//            name = "World";
//        }
//        return createMessage(name, language);
//    }

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String thegreeting = "Hello" +name + "!";
        model.addAttribute("greeting", thegreeting);
        return "hello" ;
    }


    @GetMapping("form")
    public String helloForm() {
        return "form";
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

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Launchcode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hellolist";

    }

}
