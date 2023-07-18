package com.honey.hottrack.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class YoutubeResponseDto {
    private String kind;
    private String etag;
    private List<YoutubeVideoDTO> items;
    private String nextPageToken;
    private PageInfoDTO pageInfo;

    // Getter and Setter methods for all fields

    @Getter @Setter
    public static class YoutubeVideoDTO {
        private String kind;
        private String etag;
        private String id;
        private SnippetDTO snippet;

        // Getter and Setter methods for all fields
        @Getter @Setter
        public static class SnippetDTO {
            private String publishedAt;
            private String channelId;
            private String title;
            private String description;
            private ThumbnailsDTO thumbnails;
            private String channelTitle;
            private List<String> tags;
            private String categoryId;
            private String liveBroadcastContent;
            private String defaultLanguage;
            private LocalizedDTO localized;

            // Getter and Setter methods for all fields
            @Getter @Setter
            public static class ThumbnailsDTO {
                private ThumbnailDTO defaultThumbnail;
                private ThumbnailDTO medium;
                private ThumbnailDTO high;
                private ThumbnailDTO standard;
                private ThumbnailDTO maxres;

                // Getter and Setter methods for all fields
                @Getter @Setter
                public static class ThumbnailDTO {
                    private String url;
                    private int width;
                    private int height;

                    // Getter and Setter methods for all fields
                }
            }
            @Getter @Setter
            public static class LocalizedDTO {
                private String title;
                private String description;

                // Getter and Setter methods for all fields
            }
        }
    }
    @Getter @Setter
    public static class PageInfoDTO {
        private int totalResults;
        private int resultsPerPage;

        // Getter and Setter methods for all fields
    }
}