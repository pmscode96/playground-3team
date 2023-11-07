package com.app.playground.service;


import com.app.playground.domain.VO.UserVO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Service
@Slf4j
public class KakaoService {
    public String getKaKaoAccessToken(String code){
        String accessToken = null;
        String requestURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=cdf63dee9a5bfba12afcdf5841267c52"); // TODO REST_API_KEY 입력
            sb.append("&redirect_uri=http://43.201.73.211:10000/kakao/login"); // TODO 인가코드 받은 redirect_uri 입력 수정할 부분임
            sb.append("&code=").append(code);
            bw.write(sb.toString());
            bw.flush();

            if(connection.getResponseCode() == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while((line = br.readLine()) != null){
                    result += line;
                }

                JsonElement element = JsonParser.parseString(result);
                accessToken = element.getAsJsonObject().get("access_token").getAsString();

                br.close();
                bw.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return accessToken;
    }

    public Optional<UserVO> getKaKaoInfo(String token){
        String requestURL = "https://kapi.kakao.com/v2/user/me";
        UserVO userVO = null;

        try {
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + token);

            if(connection.getResponseCode() == 200){
                userVO = new UserVO();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while((line = br.readLine()) != null){
                    result += line;
                }

                JsonElement element = JsonParser.parseString(result);
                JsonElement kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
                if (kakaoAccount == null || kakaoAccount.isJsonNull()) {
                    // kakao_account를 받아오지 못했을 경우 alert를 띄우기
                    System.out.println("Alert: 카카오 이메일 정보제공을 동의해주셔야 카카오가입이 가능합니다");
                    HttpServletResponse response = null;
                    response.sendRedirect("http://43.201.73.211:10000/login/login");
                } else {
                    // kakao_account를 정상적으로 받아왔을 경우 처리 로직
                    JsonObject kakaoAccountObj = kakaoAccount.getAsJsonObject();
                    // 이하 처리 로직 작성
                }
                JsonElement profile = kakaoAccount.getAsJsonObject().get("profile").getAsJsonObject();

                userVO.setUserKakaoEmail(kakaoAccount.getAsJsonObject().get("email").getAsString());
                userVO.setUserNickname(profile.getAsJsonObject().get("nickname").getAsString());
                userVO.setUserKakaoProfileUrl(profile.getAsJsonObject().get("thumbnail_image_url").getAsString());
                userVO.setUserSnsLoginStatus(1);
                userVO.setUserLoginCode("KAKAO");

                br.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(userVO);
    }
}
