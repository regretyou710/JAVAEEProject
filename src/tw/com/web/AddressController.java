package tw.com.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import tw.com.domain.Address;
import tw.com.domain.Category;
import tw.com.domain.User;
import tw.com.serivce.IAddressService;

@SessionAttributes(value = { "user" })
@RequestMapping("/address")
@Controller
public class AddressController {

	@Autowired
	private IAddressService addressService;

	private List<Address> addressList;

	@RequestMapping("/addAddress")
	public String addAddress(Address address, ModelMap model) {
		System.out.println("控制層: addAddress()...");
		System.out.println(address);

		User user = (User) model.get("user");
		String uid = user.getID();
		user.setID(uid);
		address.setUser(user);

		System.out.println("控制層: " + address);
		addressService.addAddress(address);
		return "forward:../address/addAddressList";
	}

	@RequestMapping("/addAddressList")
	public ModelAndView addressesList(ModelMap model) {
		System.out.println("控制層: addressesList()...");
		ModelAndView mv = new ModelAndView();

		// 在登入後只有自己能查到收貨地址，使用自己的ID當參數
		String uid = ((User) model.get("user")).getID();
		// 宣告存放返回查詢收貨地址的集合，用於顯示頁面EL表達式
		addressList = addressService.getAddresses(uid);

		mv.addObject("addressList", addressList);
		mv.setViewName("membercenter/member-address");// 因為視圖解析器前綴是根目錄所以直接進入membercenter
		return mv;
	}

	@RequestMapping("/setDefault")
	public String setDefault(String id, String isdefault, ModelMap model) {
		System.out.println("控制層: setDefault()...");

		// 邏輯層的setDefault()需傳入Address物件
		// 會使用到的屬性
		// 1.userID ->從session中拿
		// 2.Address id ->在改變默認的超連結帶上當前addressList的值，由控制層的setDefault參數接收
		// 3.Address isdefault ->在改變默認的超連結帶上當前addressList的值，由控制層的setDefault參數接收

		Address address = new Address();
		address.setId(id);
		address.setUser((User) model.get("user"));
		address.setIsdefault(isdefault);
		addressService.setDefault(address);
		return "forward:../address/addAddressList";
	}

	@RequestMapping("/delAddress")
	public @ResponseBody boolean delAddress(@RequestBody Address address) {
		System.out.println("控制層: updateAddress()...");
		System.out.println("ajax:" + address);
		boolean bool = addressService.delAddress(address.getId());
		return bool;
	}

	@RequestMapping("/updateAddress")
	public @ResponseBody boolean updateAddress(@RequestBody Address address) {
		System.out.println("控制層: updateAddress()...");
		System.out.println("ajax:" + address);
		boolean bool = addressService.updateAddress(address);
		return bool;
	}

}
