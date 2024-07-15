<%@page import="java.util.Collections"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ page import="java.io.IOException" %>
<%@ page import="com.google.api.client.googleapis.auth.oauth2.GoogleIdToken" %>
<%@ page import="com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier" %>
<%@ page import="com.google.api.client.googleapis.auth.oauth2.GooglePublicKeysManager" %>
<%@ page import="com.google.api.client.http.javanet.NetHttpTransport" %>
<%@ page import="com.google.api.client.json.JsonFactory" %>
<%@ page import="com.google.api.client.json.jackson2.JacksonFactory" %>

<%
    String idTokenString = request.getParameter("id_token");

    if (idTokenString != null) {
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        NetHttpTransport transport = new NetHttpTransport();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            .setAudience(Collections.singletonList("540622652015-mhtf329rjo58t00he69h3au7gr5uk8s8.apps.googleusercontent.com"))
            .build();

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
        	//이건 구글에서 제공하는 것이므로 자세히 볼 필요는 없습니다.
            GoogleIdToken.Payload payload = idToken.getPayload();
            String userId = payload.getSubject();
            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
			
            //이것만 보세요
            out.println("User ID: " + userId + "<br>");
            out.println("Email: " + email + "<br>");
            out.println("Email Verified: " + emailVerified + "<br>");
            out.println("Name: " + name + "<br>");
            out.println("Picture URL: " + pictureUrl + "<br>");
        } else {
            out.println("Invalid ID token.");
        }
    } else {
        out.println("No ID token provided.");
    }
%>
