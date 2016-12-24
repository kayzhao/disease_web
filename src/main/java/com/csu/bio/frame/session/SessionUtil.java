package com.csu.bio.frame.session;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csu.bio.object.model.User;

public class SessionUtil {
	private static final Log logger = LogFactory.getLog(SessionUtil.class);

	public static final String MEM_SESSION_INFO = "mem_session_info";

	public static final String LOGIN_VERIFY_CODE = "login_verify_code";

	/**
	 * 获取会员标识
	 * 
	 * @param request
	 * @return
	 */
	public static String getMemberId(HttpServletRequest request) {
		User userSession = (User) request.getSession().getAttribute(MEM_SESSION_INFO);
		if (userSession == null)
			return "";
		else
			return userSession.getId();
	}

	/**
	 * 清空session信息
	 * 
	 * @param request
	 */
	public static void clearSession(HttpServletRequest request) {

		request.getSession().removeAttribute(MEM_SESSION_INFO);
	}

	/**
	 * 获取会员session信息
	 * 
	 * @param request
	 * @return
	 */
	public static User getMemberSession(HttpServletRequest request) {
		User userSession = (User) request.getSession().getAttribute(MEM_SESSION_INFO);

		return userSession;
	}

	/**
	 * 设置会员session信息
	 * 
	 * @param request
	 * @return
	 */

	public static void setMemberSession(HttpServletRequest request, User user) {
		request.getSession().setAttribute(MEM_SESSION_INFO, user);
	}

	/**
	 * 获取网站访问根路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getSiteRoot(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		String serverName = request.getServerName();
		sb.append(request.getScheme()).append("://").append(serverName);
		if (serverName.equals("localhost") || serverName.equals("127.0.0.1")) {
			sb.append(request.getServerPort() == 80 ? "" : ":" + request.getServerPort());
		}
		sb.append(request.getContextPath());

		if (logger.isDebugEnabled()) {
			logger.debug("SiteRoot is " + sb.toString());
		}

		return sb.toString();
	}

	/**
	 * 设置登录验证码
	 * 
	 * @param request
	 * @param verifyCode
	 */
	public static void setLoginVerifyCode(HttpServletRequest request, String verifyCode) {
		request.getSession().setAttribute(LOGIN_VERIFY_CODE, verifyCode);
	}

	/**
	 * 获取登录验证码
	 * 
	 * @param request
	 * @return
	 */
	public static String getloginVerifyCode(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(LOGIN_VERIFY_CODE);
	}

}
