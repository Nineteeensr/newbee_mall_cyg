package com.cyg.newbee_mall.controller.common;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CuiYuangeng
 * @create 2021-12-08-20:43
 */
@Controller
public class KaptchaController {

    @GetMapping("/common/kaptcha")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");

        // 宽 高 位数
        SpecCaptcha captcha = new SpecCaptcha(75, 30, 4);

        // 设置类型为字母和数字组合
        captcha.setCharType(Captcha.TYPE_DEFAULT);

        // 设置字体
        captcha.setCharType(Captcha.FONT_9);

        // 验证码存入session
        session.setAttribute("verifyCode", captcha.text().toLowerCase());

        // 输出图片流
        captcha.out(response.getOutputStream());
    }

    @GetMapping("/verify")
    @ResponseBody
    public String verify(@RequestParam("code") String code, HttpSession session) {
        if (!StringUtils.hasLength(code)) {
            return "验证码不能为空";
        }
        String verifyCode = (String) session.getAttribute("verifyCode");
        if (!StringUtils.hasLength(verifyCode) || !code.toLowerCase().equals(verifyCode)) {
            return "验证码错误";
        }
        return "验证成功";
    }


}
