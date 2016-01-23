package ort.geekstagram_student.controllers;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ort.geekstagram_student.domain.User;
import ort.geekstagram_student.services.user.UserService;

@RestController
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public ArrayList<User> getUsersPage(@RequestParam(value="q", required=false) String query) {
        return (ArrayList<User>)userService.getUsersLikePseudo(query);
    }


}
