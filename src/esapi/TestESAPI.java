package esapi;

import java.io.IOException;

import org.owasp.esapi.ESAPI;

public class TestESAPI {
	//Need to add esapi properties
	public static void main(String args[]) {
		String apiToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJXQU1DTCI6eyJyaXNrVHJhbnNhY3Rpb25JRCI6IjE6NTkyOTE3NyIsImNhY2hlSWQiOiJmZmZmYmZmZjZiNDA0OGExYmFkYjg2NDU0ZWEyOWM2N18wMDAwMDE2NTgwOWI4YzVjLWExN2NlIn0sIklhdCI6IjE1MzYxMjY3ODQiLCJleHBpcmVzX2luIjoiMTgwMCIsIkp0aSI6ImJmZTUyNzNmLWQ0MDctNGVlOC1iYzhjLTEyNjliMjBhNjc4NSJ9.FzcnGwoYhQDWZigZub71wvpiLChV8PXHvVRf8jqyjDScLnI3LaQPvNqDzetuCiQK_UnrcqAl9fpQKIxgJlviA_i_dXE3a1rCUBU55c2acEk3IiipnttFAdLdOqZUe1gorfUWOF2lb5uRRDKcbujVyR2Dk7c47UHSFV5Lv7XuhZAsG-MTw6K3pTfOZn4Tr1r7oaLrPVPRzgHuRtufXOJ0xRqtXccx8flRWFwIm0OD0M3o0Ya1wTmGZGpXefv6kzoD2giosVYUYL4EC73fVmmvABVxTMgQAn459ExjvW42Cm4KvcQTzPKlkK3O8F9T4k2B0RZz482Pz2FL1K6ur927IA";
		System.out.println("Input token :" + apiToken);

		String apiTokenEncode = "";
		apiTokenEncode = ESAPI.encoder().encodeForBase64(apiToken.getBytes(), false);
		System.out.println("Input token encoded :" + apiTokenEncode);

		byte[] apiTokenDecode = null;
		StringBuffer sb = new StringBuffer();
		try {
			apiTokenDecode = ESAPI.encoder().decodeFromBase64(apiTokenEncode);
			for (int i = 0; i < apiTokenDecode.length; i++) {
				sb.append((char) apiTokenDecode[i]);
			}
			System.out.println("Input token after decoded :" + sb);

			if (apiToken.equals(sb.toString())) {
				System.out.println("input and decoded strings are same....");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
