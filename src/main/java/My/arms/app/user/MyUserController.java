package My.arms.app.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}