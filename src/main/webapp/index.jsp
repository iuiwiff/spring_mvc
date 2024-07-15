<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<!DOCTYPE html>
<html>
<head>
    <title>Google OAuth 2.0 Authentication</title>
    <script src="https://accounts.google.com/gsi/client" async defer></script>
    <script>
        function handleCredentialResponse(response) {
            // 구글 계정 정보 처리
            console.log("Encoded JWT ID token: " + response.credential);
            document.getElementById("id_token").value = response.credential;
            document.getElementById("loginForm").submit();
        }
    </script>
</head>
<body>
    <h1>Google OAuth 2.0 Authentication</h1>
    <div id="g_id_onload"
         data-client_id="540622652015-mhtf329rjo58t00he69h3au7gr5uk8s8.apps.googleusercontent.com"
         data-callback="handleCredentialResponse">
    </div>
    <div class="g_id_signin" data-type="standard"></div>

    <form id="loginForm" action="oauth2callback.jsp" method="post">
        <input type="hidden" id="id_token" name="id_token" />
    </form>
</body>
</html>