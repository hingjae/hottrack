package com.honey.hottrack.service;

import com.honey.hottrack.config.YoutubeProperties;
import com.honey.hottrack.dto.YoutubeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@Service
public class YoutubeService {

    private final RestTemplate restTemplate;
    private final YoutubeProperties youtubeProperties;

    public YoutubeResponseDto getContents(int pageSize, String pageToken) {
        URI uri = UriComponentsBuilder.fromHttpUrl(youtubeProperties.getUrl())
                .queryParam("part", "snippet")
                .queryParam("chart", "mostPopular")
                .queryParam("maxResults", pageSize)
                .queryParam("pageToken", pageToken)
                .queryParam("regionCode", "kr")
                .queryParam("key", youtubeProperties.getKey())
                .build()
                .toUri();

        return restTemplate.getForObject(uri, YoutubeResponseDto.class);
    }

}
