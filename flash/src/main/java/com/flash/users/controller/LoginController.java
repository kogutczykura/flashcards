package com.flash.users.controller;

import com.flash.users.entity.RoleType;
import com.flash.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/logged-in")
public class LoginController {
    private final UserService userService;

    @GetMapping()
    public String logged() {
        if (userService.isInRole(RoleType.PREMIUM)) {
            return "redirect:/user/premium";
        } else if (userService.isInRole(RoleType.REGULAR)) {
            return "redirect:/user/regular";
        } else {
            return "redirect:/login";
        }
    }
}
