package tw.com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tw.com.domain.Category;
import tw.com.serivce.ICategoryService;

@RequestMapping("/category")
@Controller
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	private List<Category> list;

	@RequestMapping("/addCategory")
	public String addCategory(Category category, Model model) {
		System.out.println("控制層: addCategory()...");
		String msg = "";
		// 找出分類名稱有無重複
		boolean bool = categoryService.getCategories().stream()
				.anyMatch(categories -> categories.getName().equals(category.getName()));
		System.out.println("分類名稱有無重複:" + bool);
		if (bool) {
			msg = "分類名稱已經存在";
			model.addAttribute("msg", msg);

			// return "redirect:/admincenter/product-addcategory.jsp";
			return "forward:../admincenter/product-addcategory.jsp";
		}
		if (category.getName().trim().equals("")) {
			msg = "請輸入分類名稱";
			model.addAttribute("msg", msg);

			return "forward:../admincenter/product-addcategory.jsp";
		}
		categoryService.addCategory(category);
		System.out.println(category);
		return "forward:../category/getCategories";
	}

	@RequestMapping("/getCategories")
	public ModelAndView getCategories() {
		System.out.println("控制層: getCategories()...");

		// 宣告存放返回查詢分類列表的集合，用於顯示頁面EL表達式
		list = categoryService.getCategories();
		System.out.println("控制層: " + list);

		ModelAndView mv = new ModelAndView();
		mv.addObject("categoryList", list);
		mv.setViewName("/admincenter/product-categorylist");
		// return "redirect:/admincenter/product-categorylist.jsp";
		return mv;
	}

	@RequestMapping("/delCategory")
	public @ResponseBody boolean delCategory(@RequestBody Category category) {
		System.out.println("控制層: delCategory()...");
		System.out.println("ajax:" + category);
		boolean bool = categoryService.delCategory(category.getId());
		return bool;
	}
	
	@RequestMapping("/updateCategory")
	public @ResponseBody boolean updateCategory(@RequestBody Category category) {
		System.out.println("控制層: updateCategory()...");
		System.out.println("ajax:" + category);
		boolean bool = categoryService.updateCategory(category);
		return bool;
	}
}
