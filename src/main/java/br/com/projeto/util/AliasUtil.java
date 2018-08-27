package br.com.projeto.util;

import java.util.Random;

public class AliasUtil {

	public static String createAlias() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(str.charAt(random.nextInt(str.length())));
		}

		return sb.toString();
	}
}
