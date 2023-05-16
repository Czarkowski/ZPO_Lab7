package com.example.ZPO_Lab7;

import jakarta.servlet.http.HttpSession;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @GetMapping({"/"})
    public String index(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/students";
        ParameterizedTypeReference<List<Student>> responseType = new ParameterizedTypeReference<List<Student>>() {};
        ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        List<Student> students = responseEntity.getBody();

        model.addAttribute("Students", students);

        return "index";
    }

//    @PostMapping({"/getById"})
//    public String getById(Model model, @ModelAttribute("Student") Student student){
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/students/"+student.getId().toString();
//        System.out.println(url);
//        Student forObject = restTemplate.getForObject(url, Student.class);
//        System.out.println(forObject.toString());
//        model.addAttribute("Student",forObject);
//        return "index";
//    }

    @GetMapping({"/getById"})
    public String getById(Model model){
        return "getById";
    }

    @PostMapping("/getById")
    public String getByIdPost(@RequestParam("id") int id, HttpSession httpSession) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/students/"+id;

        Student forObject = restTemplate.getForObject(url, Student.class);

        httpSession.setAttribute("student", forObject);
        return "redirect:/response";
    }

    @GetMapping({"/add"})
    public String add(Model model){
        Student student = new Student();
        model.addAttribute("Student",student);
        return "add";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute("Student") Student student, HttpSession httpSession) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/students";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Student> requestEntity = new HttpEntity<>(student, headers);

        Student forObject = restTemplate.postForObject(url,requestEntity, Student.class);


        httpSession.setAttribute("student", forObject);

        return "redirect:/response";
    }

    @GetMapping({"/update"})
    public String update(Model model){
        Student student = new Student();
        model.addAttribute("Student",student);
        return "update";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("Student") Student student, HttpSession httpSession) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/students/"+ student.getId();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Student> requestEntity = new HttpEntity<>(student, headers);

        ResponseEntity<Student> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Student.class);

        httpSession.setAttribute("student", responseEntity.getBody());

        return "redirect:/response";
    }

    @GetMapping({"/delete"})
    public String delete(Model model){
        return "delete";
    }

    @PostMapping("/delete")
    public String deletePost(@RequestParam("id") int id, HttpSession httpSession) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/students/"+id;

        ResponseEntity<Student> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, Student.class);

        httpSession.setAttribute("student", responseEntity.getBody());
        return "redirect:/response";

    }

    @GetMapping({"/response"})
    public String response(Model model,HttpSession httpSession){
        Student student = (Student) httpSession.getAttribute("student");
        model.addAttribute("student",student);
        return "response";
    }

    @GetMapping({"/ex"})
    public ModelAndView ex(Model model){
        ModelAndView modelAndView = new ModelAndView("error/404"); // Nazwa widoku strony błędu 404
        modelAndView.addObject("message", "Client with id not found"); // Dodanie dodatkowych danych do widoku
        return modelAndView;
    }
}

