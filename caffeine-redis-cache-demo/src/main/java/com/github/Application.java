package com.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);

		redisKey("UserId");
		redisKey("userId");
		redisKey("userID");
		redisKey("UID");
	}

	public static String redisKey(String s) {

		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (i ==0 && Character.isUpperCase(c)) {
				c = Character.toLowerCase(c);
			}

			if (Character.isUpperCase(c)) {
				stringBuffer.append(":").append(Character.toLowerCase(c));
			} else {
				stringBuffer.append(c);
			}
		}

		System.err.println(stringBuffer);

		return stringBuffer.toString();

	}
}

