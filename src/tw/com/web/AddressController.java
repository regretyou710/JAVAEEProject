package tw.com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.com.domain.Address;
import tw.com.domain.User;
import tw.com.serivce.IAddressService;

@SessionAttributes(value = { "user" })
@RequestMapping("/address")
@Controller
public class AddressController {

	@Autowired
	private IAddressService addressService;

	@RequestMapping("/addAddress")
	public String addAddress(Address address, ModelMap model) {
		System.out.println("控制層: addAddress()...");
		// String uid= ((User)model.get("user")).getID();
		// address.getUser().setID(uid);
		//
		User user = (User) model.get("user");
		String uid = user.getID();
		user.setID(uid);
		address.setUser(user);
		System.out.println("控制層: " + address);
		addressService.addAddress(address);
		return "member-address.jsp";
	}

}
