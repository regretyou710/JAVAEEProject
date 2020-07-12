package tw.com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import tw.com.domain.Address;
import tw.com.domain.User;
import tw.com.serivce.IAddressService;

@SessionAttributes(value={"user","addressList"})
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
		return "redirect:../address/addAddressList";
	}

	@RequestMapping("/addAddressList")
	public String addressesList(ModelMap model) {
		//宣告存放返回查詢收貨地址的集合，用於顯示頁面EL表達式
		String uid = ((User) model.get("user")).getID();		
		addressList = addressService.getAddresses(uid);
		model.addAttribute("addressList",addressList);
		return "forward:/membercenter/member-address.jsp";
		
	}
}
