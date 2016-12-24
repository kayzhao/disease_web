package com.csu.bio.controller.pub;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * @author kayzhao
 */
@Controller
public class XkaptchaController {

	private final Logger logger = Logger.getLogger(XkaptchaController.class);

	private Producer captchaProducer;

	public Producer getCaptchaProducer() {
		return captchaProducer;
	}

	@Autowired
	public void setCaptchaProducer(Producer captchaProducer) {
		this.captchaProducer = captchaProducer;
	}

	@RequestMapping(value = "/captcha.do", method = RequestMethod.GET)
	public void initCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = null;
		while (true) {
			capText = captchaProducer.createText();
			if (isOkay(capText)) {
				break;
			} else {
				continue;
			}
		}
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		ServletOutputStream out = response.getOutputStream();

		BufferedImage bi = captchaProducer.createImage(capText);
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}

	private boolean isOkay(String strs) {
		for (int i = 0; i < strs.length(); i++) {
			for (int j = i + 1; j < strs.length(); j++) {
				if (strs.charAt(i) == strs.charAt(j) && j == (i + 1)) {
					return false;
				}
			}
		}
		return true;
	}
}
