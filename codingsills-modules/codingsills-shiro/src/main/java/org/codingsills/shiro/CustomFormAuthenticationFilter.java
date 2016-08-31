package org.codingsills.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.codingsills.jcaptcha.JCaptchaKit;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	private boolean jcaptchaEnabled = true;// 是否开启验证码支持

	private String jcaptchaParam = "jcaptchaCode";// 前台提交的验证码参数

	public void setJcaptchaEnabled(boolean jcaptchaEnabled) {
		this.jcaptchaEnabled = jcaptchaEnabled;
	}

	public void setJcaptchaParam(String jcaptchaParam) {
		this.jcaptchaParam = jcaptchaParam;
	}
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		//1.设置验证码是否开启属性，页面可以根据该属性来决定是否显示验证码
		request.setAttribute("jcaptchaEnabled", jcaptchaEnabled);
		
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		
		//2.判断验证码是否禁用 或不是表单提交（允许访问）
		if(jcaptchaEnabled == false || !"post".equalsIgnoreCase(httpServletRequest.getMethod())){
			return super.isAccessAllowed(request, response, mappedValue);
		}
		//3.此时是表单提交，验证验证码是否正确 
		if(!JCaptchaKit.validateResponse(httpServletRequest, httpServletRequest.getParameter(jcaptchaParam))){
			request.setAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, "jcaptcha.error");
			return false;
		}
		return super.isAccessAllowed(request, response, mappedValue);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		if(request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME) !=null){
			return true;
		}
		return super.onAccessDenied(request, response, mappedValue);
	}
	
	

}
