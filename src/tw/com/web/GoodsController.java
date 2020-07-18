package tw.com.web;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.com.domain.Category;
import tw.com.domain.Goods;
import tw.com.domain.User;
import tw.com.serivce.ICategoryService;
import tw.com.serivce.IGoodsService;
import tw.com.util.DateTimeUtil;
import tw.com.util.UUIDUtil;

@RequestMapping("/goods")
@Controller
public class GoodsController {

	@Autowired
	private ICategoryService categorySerciet;
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private HttpServletRequest request;
	private String goodsNo;
	private List<Category> categoryList;
	private List<Object[]> goodsList;

	@RequestMapping("/addGoodsCategory")
	public String addGoodsCategory(Model model) {
		System.out.println("控制層: addGoodsCategory()...");
		// 商品貨號由系統產生
		goodsNo = "Happy" + DateTimeUtil.getGoodsNo();
		// 在添加商品中的所屬分類下拉選項列出清單
		categoryList = categorySerciet.getCategories();

		model.addAttribute("goodsNo", goodsNo);
		model.addAttribute("categoryList", categoryList);
		return "forward:../admincenter/picture-add.jsp";
	}

	@RequestMapping("/addGoods")
	public String addGoods(@RequestParam(value = "upload", required = false) MultipartFile thumbnail, Goods goods) {
		System.out.println("控制層: addGoods()...");
		if (thumbnail != null) {
			String thumbnailURL = uploadThumbnail(thumbnail);
			goods.setThumbnail(thumbnailURL);
		}
		System.out.println(goods);
		goodsService.addGoods(goods);
		return "forward:../goods/getGoods";
	}

	public String uploadThumbnail(MultipartFile thumbnail) {
		System.out.println("控制層: uploadAvatar()...");
		// 封裝上傳物件後，使用Request物件解析物件內容
		// 1.指定上傳文件的存放路徑
		Path path = Paths.get(request.getServletContext().getRealPath("/goodsImages/"));
		System.out.println("上傳文件的存放路徑:" + path);

		String suffix = "";// (前綴)檔案名稱由亂數產生命名
		String thumbnailName = UUIDUtil.getRandomByUUID();
		try {
			// 2.判斷路徑是否存在
			if (Files.notExists(path))
				// 如果目錄(路徑)不存在，則建立
				Files.createDirectory(path);

			// 3.解析Request物件，獲取上傳文件項目

			if (thumbnail != null) {
				if (!thumbnail.getOriginalFilename().equals("")) {
					// 取得上傳文件項目名稱
					String fileName = thumbnail.getOriginalFilename();
					// 把文件名稱設為唯一值
					suffix = thumbnailName + fileName.substring(fileName.lastIndexOf("."));
					// 完成文件上傳
					// 將上傳路徑加上檔案名稱透過File建立成物件，文件項目寫出目的地
					thumbnail.transferTo(new File(path.toString(), suffix));
				} else {
					throw new RuntimeException("上傳商品縮圖異常");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "goodsImages/" + suffix;// 將上傳圖片存到DB
	}

	@RequestMapping("/getGoods")
	public String getGoods(Model model, Goods goods) {
		System.out.println("控制層: getGoods()...");
		System.out.println("----------->" + goods);

		// 在添加商品中的所屬分類下拉選項列出清單
		categoryList = categorySerciet.getCategories();
		model.addAttribute("categoryList", categoryList);

		Object[] obj = new Object[] { goods.getName(), goods.getCategory(), goods.getPrice2(), goods.getStock() };

		// 建立一個接受顯示商品清單的集合
		goodsList = goodsService.getGoods(obj);
		model.addAttribute("goodsList", goodsList);
		System.out.println(goodsList);
		return "forward:../admincenter/product-list.jsp";
	}
}
