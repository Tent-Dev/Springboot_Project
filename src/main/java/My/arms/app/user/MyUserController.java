package My.arms.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import My.arms.domain.component.PageWrapper;
import My.arms.domain.entity.User;
import My.arms.domain.service.MyUserService;

@Controller
public class MyUserController {
	
	@Secured("ROLE_USER")
	@ResponseBody
	@RequestMapping("/user/user")
	public String user(){
		return "Only ROLE_USER can access this page";
	}
	
	@Secured("ROLE_ADMIN")
	@ResponseBody
	@RequestMapping("/admin/user")
	public String admin(){
		return "Only ROLE_AMIN can access this page";
	}
	
	//Pagination
	@Autowired
	MyUserService userService;
	
	@RequestMapping("/list")
	   public String list(Model model, Pageable pageable) {
	        Page<User> pageUserList = userService.getAllUsers(pageable);
	        PageWrapper<User> page = new PageWrapper<User>(pageUserList, "/list");
	        model.addAttribute("page", page);
	        model.addAttribute("users", page.getContent());
	        return "user/list";
	    }



}