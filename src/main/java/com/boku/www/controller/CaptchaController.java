/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CaptchaController
 * Author:   dell
 * Date:     2019/8/5 9:01
 * Description: 验证码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.controller;

/**
 * 〈一句话功能简述〉<br> 
 * 〈验证码〉
 *
 * @author dell
 * @create 2019/8/5
 * @since 1.0.0
 */
import com.boku.www.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class CaptchaController {

	public static final String KEY_CAPTCHA = "KEY_CAPTCHA";

	@RequestMapping("/Captcha.jpg")
	public void getCaptcha(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 设置相应类型,告诉浏览器输出的内容为图片
		response.setContentType("image/jpeg");
		// 不缓存此内容
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		try {

			HttpSession session = request.getSession();

			CaptchaUtil tool = new CaptchaUtil();
			StringBuffer code = new StringBuffer();
			BufferedImage image = tool.genRandomCodeImage(code);
			session.removeAttribute(KEY_CAPTCHA);
			session.setAttribute(KEY_CAPTCHA, code.toString());

			// 将内存中的图片通过流动形式输出到客户端
			ImageIO.write(image, "JPEG", response.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}