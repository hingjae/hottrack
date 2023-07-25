package com.honey.hottrack.controller;

import com.honey.hottrack.dto.YoutubeResponseDto;
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
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false) String pageToken,
            Model model
    ) {
        YoutubeResponseDto contents = youtubeApiController.getContents(pageSize, pageToken);
        model.addAttribute("contents", contents.getItems());
        model.addAttribute("pageSize", contents.getPageInfo().getResultsPerPage());
        model.addAttribute("nextPageToken", contents.getNextPageToken());
        return "home";
    }
}
