package org.codingsills.jcaptcha;

import javax.servlet.http.HttpServletRequest;

public class JCaptchaKit {
	
	public static final CustomManageableImageCaptchaService captchaService
		= new CustomManageableImageCaptchaService();
	
	/**
	 * 验证当前请求输入的验证码否正确；并从CaptchaService中删除已经生成的验证码；
	 * */
	public static boolean validateResponse(HttpServletRequest request, String userCaptchaResponse){
		if(request.getSession(false) == null) return false;
		boolean validated = false;
		try {
			String id = request.getSession().getId();
			validated = captchaService.validateResponseForID(id, userCaptchaResponse).booleanValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validated;
	}
	
	/**
	 * 验证当前请求输入的验证码是否正确；
	 * 但不从CaptchaService中删除已经生成的验证码（比如Ajax验证时可以使用，防止多次生成验证码）；
	 * */
	public static boolean hasCaptcha(HttpServletRequest request, String userCaptchaResponse){
		if(request.getSession(false) == null) return false;
		boolean validated = false;
		try {
			String id = request.getSession().getId();
			validated = captchaService.hasCaptcha(id, userCaptchaResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validated;
	}

}
