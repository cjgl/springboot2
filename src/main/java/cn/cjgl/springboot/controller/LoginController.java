package cn.cjgl.springboot.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("index");
		modelAndView.addObject("sessionId", request.getSession().getId());
		return modelAndView;
	}
	
	@RequestMapping("/")
	public ModelAndView index0(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("index");
		modelAndView.addObject("sessionId", request.getSession().getId());
		return modelAndView;
	}
	
	@RequestMapping("/main")
	public ModelAndView main(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("main");
		modelAndView.addObject("sessionId", request.getSession().getId());
		return modelAndView;
	}
	
	@RequestMapping(value="/validateCode")
	public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		log.info("validateCode");
		
		//在内存中创建图象
		int width=65, height=20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		//生成随机类
		Random random = new Random();
		//设定背景色
		g.setColor(getRandColor(200,250));
		g.fillRect(0, 0, width, height);
		//设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		//随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i=0;i<155;i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x,y,x+xl,y+yl);
		}
		//取随机产生的认证码(6位数字)
		String sRand="";
		for (int i=0;i<4;i++){
			String rand=codeArray[random.nextInt(61)]+"";//String.valueOf(random.nextInt(10));
			sRand+=rand;
			//将认证码显示到图象中
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand,13*i+6,16);
		}
		//将认证码存入SESSION
		request.getSession().setAttribute("s_validateCode", sRand);
		log.debug("validateCode : " + sRand);
		//图象生效
		g.dispose();
		
		response.setHeader("Pragma", "no-cache");         
		response.setHeader("Cache-Control", "no-cache");         
		response.setDateHeader("Expires", 0);         
		response.setContentType("image/jpeg");
		
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(response.getOutputStream());
		ImageIO.write(image, "JPEG", imageOut);
		imageOut.close();
		
	}
	
	public static char[] codeArray = {'1','2','3','4','5','6','7','8','9',
			'a','b','c','d','e','f','g',
			'h','i','j','k','l','m','n',
			'o','p','q','r','s','t',
			'u','v','w','x','y','z',
			'A','B','C','D','E','F','G',
			'H','I','J','K','L','M','N',
			'O','P','Q','R','S','T',
			'U','V','W','X','Y','Z'};
	
	/*  
	 * 给定范围获得随机颜色  
	 */
	private Color getRandColor(int fc,int bc){
		Random random = new Random();
		if(fc>255) fc=255;
		if(bc>255) bc=255;
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		return new Color(r,g,b);
	}
	
}
