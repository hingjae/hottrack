package com.honey.hottrack.service;

import com.honey.hottrack.config.KeyProperties;
import com.honey.hottrack.config.UrlProperties;
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
    private final UrlProperties urlProperties;
    private final KeyProperties key;

    public YoutubeResponseDto getContents(int pageSize) {
        URI uri = UriComponentsBuilder.fromHttpUrl(urlProperties.getYoutube())
                .queryParam("part", "snippet")
                .queryParam("chart", "mostPopular")
                .queryParam("maxResults", pageSize)
                .queryParam("regionCode", "kr")
                .queryParam("key", key.getYoutube())
                .build()
                .toUri();

        return restTemplate.getForObject(uri, YoutubeResponseDto.class);
    }

}
