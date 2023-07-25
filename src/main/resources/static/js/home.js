// script.js

// 페이지 로딩 시 토글 버튼 초기 상태를 설정합니다.
// 설명의 문자 길이에 따라 버튼이 생성되거나 숨겨집니다.
document.addEventListener('DOMContentLoaded', function () {
    // 페이지 로딩 시 토글 버튼 초기 상태를 설정합니다.
    // 설명의 문자 길이에 따라 버튼이 생성되거나 숨겨집니다.
    const toggleButtons = document.querySelectorAll('.toggle-btn');
    toggleButtons.forEach(btn => {
        const descriptionContainer = btn.previousElementSibling;
        const contentLength = descriptionContainer.getAttribute('data-content-length');
        if (contentLength <= 120) {
            btn.style.display = 'none'; // 문자 길이가 120 이하인 경우 버튼을 숨깁니다.
        }
        btn.addEventListener('click', function () {
            toggleDescription(btn);
        });
    });

    function toggleDescription(btn) {
        var descriptionContainer = btn.previousElementSibling;
        descriptionContainer.classList.toggle('show-description');
        // 토글 버튼의 텍스트를 변경합니다.
        if (btn.innerText === '더보기') {
            btn.innerText = '접기';
        } else {
            btn.innerText = '더보기';
        }
    }
});

async function loadMoreVideos() {
    const pageSize = document.getElementById('pageSize').value;
    const nextPageToken = document.getElementById('nextPageToken').value;

    try {
        // YouTube API 호출 (비동기로 수행)
        const response = await fetch(`/api/youtube?pageSize=${pageSize}&pageToken=${nextPageToken}`);
        const data = await response.json();

        const videoListElement = document.getElementById('videoList');
        // 가져온 동영상 데이터를 화면에 추가하는 로직을 구현합니다.
        data.items.forEach(video => {
            const cardDiv = document.createElement('div');
            cardDiv.className = 'card';

            const iframeElement = document.createElement('iframe');
            iframeElement.src = `https://www.youtube.com/embed/${video.id}`;
            cardDiv.appendChild(iframeElement);

            const titleElement = document.createElement('h2');
            titleElement.textContent = video.snippet.title;
            cardDiv.appendChild(titleElement);

            const descriptionContainer = document.createElement('div');
            descriptionContainer.className = 'description-container';
            descriptionContainer.setAttribute('data-content-length', video.snippet.description.length);
            const descriptionParagraph = document.createElement('p');
            descriptionParagraph.textContent = video.snippet.description;
            descriptionContainer.appendChild(descriptionParagraph);
            cardDiv.appendChild(descriptionContainer);

            if (video.snippet.description.length > 120) {
                const toggleButton = document.createElement('a');
                toggleButton.href = 'javascript:void(0)';
                toggleButton.className = 'toggle-btn';
                toggleButton.textContent = '더보기';
                toggleButton.onclick = function() {
                    toggleDescription(this);
                };
                cardDiv.appendChild(toggleButton);
            }

            videoListElement.appendChild(cardDiv);
        });

        // 다음 페이지를 가져오기 위한 토큰 업데이트
        document.getElementById('nextPageToken').value = data.nextPageToken;

        // 더 이상 다음 페이지가 없으면 더보기 버튼을 숨깁니다.
        if (!data.nextPageToken) {
            document.getElementById('loadMoreVideo').style.display = 'none';
        }
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

document.getElementById('loadMoreVideo').addEventListener('click', loadMoreVideos);

$(document).ready(function() {
    loadMoreVideos();
});