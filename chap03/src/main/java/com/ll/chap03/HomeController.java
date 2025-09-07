package com.ll.chap03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("a")
    @ResponseBody
    public String hello(
            String age,
            String id
    ){
        return "안녕하세요, %s번 사람의 나이는 %s살 입니다.".formatted(id, age);
    }
    @GetMapping("b")
    @ResponseBody
    public String plus(
            @RequestParam("a") int num1,
            @RequestParam("b") int num2,
            @RequestParam(name="c", defaultValue = "10") int num3
    ){
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        return "a + b + c = %d".formatted(num1+num2+num3);
    }
    @GetMapping("c")
    @ResponseBody
    public String c(
            boolean married
    ){
        return married ? "결혼" : "미혼";
    }
    @GetMapping("d")
    @ResponseBody
    public String d(
            Boolean married
    ){
        if ( married == null ) return "정보를 입력하세요.";
        return married ? "결혼" : "미혼";
    }

    public static class Person {

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    @GetMapping("person1")
    @ResponseBody
    public String person(
            String name,
            int age
    ){
        Person person = new Person(name,age);

        return person.toString();
    }
    @GetMapping("person2")
    @ResponseBody
    public String person(
            Person person
    ){
        return person.toString();
    }
    @GetMapping("e")
    @ResponseBody
    public int e(){
        int age = 100;
        return age;
    }
    @GetMapping("f")
    @ResponseBody
    public boolean f(){
        boolean married = false;

        return married;
    }
    @GetMapping("g")
    @ResponseBody
    public Person g(){
        Person person = new Person("Paul",22);
        return person;
    }
    @GetMapping("h")
    @ResponseBody
    public int[] h() {
        int[] arr = new int[]{10, 20, 30};

        return arr;
    }
    @GetMapping("i")
    @ResponseBody
    public List<Integer> i() {
        List<Integer> arr = List.of(10,20,30);
        return arr;
    }
    @GetMapping("j")
    @ResponseBody
    public Map<String, Object> j() {
        Map<String, Object> person = new HashMap<>();

        person.put("age", 22);
        person.put("name", "Paul");

        return person;
    }
}
