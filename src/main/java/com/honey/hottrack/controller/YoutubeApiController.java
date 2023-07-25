package com.honey.hottrack.controller;

import com.honey.hottrack.dto.YoutubeResponseDto;
import com.honey.hottrack.service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class YoutubeApiController {

    private final YoutubeService youtubeService;

    @GetMapping("/api/youtube")
    public YoutubeResponseDto getContents(int pageSize, @RequestParam(required = false) String pageToken) {
        return youtubeService.getContents(pageSize, pageToken);
    }
}
