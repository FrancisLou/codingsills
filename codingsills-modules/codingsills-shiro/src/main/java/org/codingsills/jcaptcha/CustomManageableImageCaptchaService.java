package org.codingsills.jcaptcha;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.engine.image.gimpy.GmailEngine;
import com.octo.captcha.service.captchastore.CaptchaStore;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

public class CustomManageableImageCaptchaService extends DefaultManageableImageCaptchaService{

	public CustomManageableImageCaptchaService() {
		super(new FastHashMapCaptchaStore(), new GmailEngine(), 180, 100000, 75000);
	}

	public CustomManageableImageCaptchaService(CaptchaStore captchaStore, CaptchaEngine captchaEngine,
			int minGuarantedStorageDelayInSeconds, int maxCaptchaStoreSize,
			int captchaStoreLoadBeforeGarbageCollection) {
		super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds, maxCaptchaStoreSize,
				captchaStoreLoadBeforeGarbageCollection);
	}
	
	public boolean hasCaptcha(String id, String userCaptchaResponse){
		return store.getCaptcha(id).validateResponse(userCaptchaResponse);
	}
	
}
