package org.codingsills.modules.utils;

import org.junit.Test;

public class DigestsTest {

	@Test
	public void digestString() {
		String input = "user";
		byte[] sha1Result = Digests.sha1(input.getBytes());
		System.out.println("sha1 in hex result                               :" + Encodes.encodeHex(sha1Result));

		byte[] salt = Digests.generateSalt(8);
		System.out.println("salt in hex                                      :" + Encodes.encodeHex(salt));
		sha1Result = Digests.sha1(input.getBytes(), salt);
		System.out.println("sha1 in hex result with salt                     :" + Encodes.encodeHex(sha1Result));

		sha1Result = Digests.sha1(input.getBytes(), salt, 1024);
		System.out.println("sha1 in hex result with salt and 1024 interations:" + Encodes.encodeHex(sha1Result));

	}

}
