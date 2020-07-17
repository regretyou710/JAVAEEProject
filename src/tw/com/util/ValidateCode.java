package tw.com.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

/**
 * 验证码生成器
 * 
 * @author dsna
 *
 */
@Scope(scopeName = "prototype")
@Component
public class ValidateCode {

	private ImgFontByte imgFont;
	// 图片的宽度。
	private int width = 120;
	// 图片的高度。
	private int height = 40;
	// 验证码字符个数
	private int codeCount = 5;
	// 验证码干扰线数
	private int lineCount = 100;
	// 验证码
	private String code;
	// 验证码图片Buffer
	private BufferedImage buffImg = null;

	private ByteArrayBuffer byteImge;

	private int x = 0;
	private int codeY;
	private String fontStyle;
	private int fontHeight;

	private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public ValidateCode() {
		this.createCode();
	}

	/**
	 * 
	 * @param width
	 *            图片宽
	 * @param height
	 *            图片高
	 */
	public ValidateCode(int width, int height) {
		this.width = width;
		this.height = height;
		this.createCode();
	}

	/**
	 * 
	 * @param width
	 *            图片宽
	 * @param height
	 *            图片高
	 * @param codeCount
	 *            字符个数
	 * @param lineCount
	 *            干扰线条数
	 */
	public ValidateCode(int width, int height, int codeCount, int lineCount) {

		this.width = width;
		this.height = height;
		this.codeCount = codeCount;
		this.lineCount = lineCount;

		x = width / (codeCount + 1);
		fontHeight = height - 2;
		codeY = height - 12;
		this.createCode();
	}

	public void createCode() {
		int x = 0, fontHeight = 0, codeY = 0;
		int red = 0, green = 0, blue = 0;

		x = width / (codeCount + 2);// 每个字符的宽度
		fontHeight = height - 2;// 字体的高度
		codeY = height - 4;

		// 图像buffer
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 生成随机数
		Random random = new Random();
		// 将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 创建字体
		imgFont = new ImgFontByte();
		Font font = imgFont.getFont(fontHeight);
		g.setFont(font);

		for (int i = 0; i < lineCount; i++) {
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int xe = xs + random.nextInt(width / 8);
			int ye = ys + random.nextInt(height / 8);
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawLine(xs, ys, xe, ye);
		}

		// randomCode记录随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount个字符的验证码。
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i + 1) * x, codeY);
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
		}
		// 将四位数字的验证码保存到Session中。
		code = randomCode.toString();

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	// protected void createCode() {
	//
	//
	// // 在内存中创建图象
	// buffImg = new BufferedImage(width, height,
	// BufferedImage.TYPE_INT_RGB);
	//
	// // 获取图形上下文
	// Graphics2D g = buffImg.createGraphics();
	//
	// // 生成随机类
	// Random random = new Random();
	//
	// // 设定背景色
	// g.setColor(Color.WHITE);
	//
	// g.fillRect(0, 0, width, height);
	//
	// // 设定字体
	// g.setFont(new Font(fontStyle, Font.PLAIN + Font.ITALIC, fontHeight));
	//
	// // 画边框
	// g.setColor(new Color(55, 55, 12));
	// g.drawRect(0, 0, width - 1, height - 1);
	//
	// // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
	// g.setColor(getRandColor(160, 200));
	// for (int i = 0; i < 160; i++) {
	// int x = random.nextInt(width);
	// int y = random.nextInt(height);
	// int xl = random.nextInt(12);
	// int yl = random.nextInt(12);
	// g.drawLine(x, y, x + xl, y + yl);
	// }
	//
	// // 取随机产生的认证码(4位数字)
	// int red = 0, green = 0, blue = 0;
	// for (int i = 0; i < codeCount; i++) {
	// red = random.nextInt(255);
	// green = random.nextInt(255);
	// blue = random.nextInt(255);
	// int wordType = random.nextInt(3);
	// char retWord = 0;
	// switch (wordType) {
	// case 0:
	// retWord = this.getSingleNumberChar();
	// break;
	// case 1:
	// retWord = this.getLowerOrUpperChar(0);
	// break;
	// case 2:
	// retWord = this.getLowerOrUpperChar(1);
	// break;
	// }
	// code += String.valueOf(retWord);
	// g.setColor(new Color(red, green, blue));
	// g.drawString(String.valueOf(retWord), (i) * x, codeY);
	//
	// }
	// // 将认证码存入SESSION
	//
	// // 图象生效
	// g.dispose();
	// }

	Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public void write(String path) throws IOException {
		OutputStream sos = new FileOutputStream(path);
		this.write(sos);
	}

	public void write(OutputStream sos) throws IOException {
		ImageIO.write(buffImg, "png", sos);
		sos.close();
	}

	public BufferedImage getBuffImg() {
		return buffImg;
	}

	public String getCode() {
		return code;
	}

	private char getSingleNumberChar() {
		Random random = new Random();
		int numberResult = random.nextInt(10);
		int ret = numberResult + 48;
		return (char) ret;
	}

	private char getLowerOrUpperChar(int upper) {
		Random random = new Random();
		int numberResult = random.nextInt(26);
		int ret = 0;
		if (upper == 0) {// 小写
			ret = numberResult + 97;
		} else if (upper == 1) {// 大写
			ret = numberResult + 65;
		}
		return (char) ret;
	}

}