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