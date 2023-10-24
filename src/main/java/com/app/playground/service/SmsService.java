package com.app.playground.service;

import java.util.HashMap;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class SmsService {
    public void certifiedPhoneNumber(String phoneNumber, String cerNum) {

        String api_key = "NCS5VPI8KP8WYZKH";
        String api_secret = "K8U1DT2PEENNCW7W8OOZCZLNGQLVA3WR";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);    // 수신전화번호
        params.put("from", "01030994708");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "놀이터 휴대폰인증 테스트 메시지 : 인증번호는" + "["+cerNum+"]" + "입니다.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            log.info(String.valueOf(params));
//            JSONObject simpleObj = (JSONObject) coolsms.send(params);
//
//            // org.json.simple.JSONObject를 문자열로 변환
//            String jsonString = simpleObj.toJSONString();
//
//            // 문자열을 com.google.gson.JsonObject로 변환
//            JsonObject gsonJsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
//
//            System.out.println(gsonJsonObject.toString());
        }catch (Exception e){

        }
//        } catch (CoolsmsException e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.getCode());
//        }

    }
}