function joinValidation() {

    const pw = document.getElementById("password").value;
    const pw2 = document.getElementById("pwChk").value;
    const nickname = document.getElementById("nickname").value;
    const username = document.getElementById("username").value;
    const mailOk = document.getElementById("mailOk").value;
    const nickOk = document.getElementById("nickOk").value;

    if (mailOk != "mailSuccess") {
        alert("메일 인증을 완료해 주세요.");
        return false;
    }

    if (nickOk != "nickSuccess") {
        alert("닉네임 중복검사를 완료해주세요.");
        return false;
    }

    const regexId = /^[a-z0-9]{6,12}$/;
    const regexPw = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{10,15}$/;

    if (username == "") {
        alert("아이디를 입력해주세요.");
        return false;
    }

    if (nickname == "") {
        alert("닉네임을 입력해주세요.");
        return false;
    }
    if (nickname.length < 3) {
        alert("닉네임은 3글자 이상으로 입력해주세요.");
        return false;
    }
    if (pw == '' || pw2 == '') {
        alert("비밀번호를 입력해주세요.");
        return false;
    }
    if (!regexPw.test(pw)) {
        alert("비밀번호 양식을 확인해주세요. (10~15자의 영문,숫자,특수문자 조합)");
        return false;
    }
    if (pw != pw2) {
        alert("비밀번호를 확인해주세요.");
        return false;
    }

    $.ajax({
        type: "POST",
        url: "/auth/join",
        data: {
            username: username,
            password: pw,
            nickname: nickname
        },
        success: function (result) {
            if (result) {
                alert("회원가입이 완료되었습니다.");
                location.href = "/auth/login";
            } else {
                alert("유효하지 않은 요청입니다. 다시 시도해주세요.");
                location.reload();
            }

        }

    })

}


function loginCheck() {

    const username = $("#username").val();
    const password = $("#password").val();

    if (username == "") {
        alert("아이디를 입력해주세요.");
        return false;
    }
    if (password == "") {
        alert("비밀번호를 입력해주세요.");
        return false;
    }
}


function sendNewPw() {
    const email = $("#email").val();
    const regEmail = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
    if (regEmail.test(email)) {
    } else {
        alert("유효하지 않은 이메일 양식입니다.");
        return false;
    }
    let loading = "";

    loading += '<div id="load" class="d-flex justify-content-center">';
    loading += '<div class="spinner-border text-danger" role="status">';
    loading += '<span class="sr-only">Loading...</span>';
    loading += '</div></div>'
    $("#loading").append(loading);

    $.ajax({
        type: "POST",
        url: "/newPw",
        data: {
            email: email
        },
        success: function (result) {
            if (result == true) {
                $("#load").remove();
                alert("임시 비밀번호가 발송됐습니다. 메일을 확인해주세요.");
                location.href = "/auth/login";
            } else {
                $("#load").remove();
                alert("존재하는 유저가 아닙니다. 메일주소를 확인해주세요.");
            }
        }
    })
}