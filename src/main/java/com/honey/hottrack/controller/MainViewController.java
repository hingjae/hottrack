package com.honey.hottrack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
@RequiredArgsConstructor
@Controller
public class MainViewController {

    private final YoutubeApiController youtubeApiController;

    @GetMapping
    public String home(
            @RequestParam(required = false, defaultValue = "10")int pageSize,
            Model model
    ) {
        model.addAttribute("contents", youtubeApiController.getContents(pageSize).getItems());
        return "home";
    }
}
