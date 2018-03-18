package work.jianhanglin.spring.boot.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import work.jianhanglin.spring.boot.blog.domain.User;
import work.jianhanglin.spring.boot.blog.domain.Authority;
import work.jianhanglin.spring.boot.blog.service.AuthorityService;
import work.jianhanglin.spring.boot.blog.service.UserService;

/**
 * 主页控制器.
 * 
 * @author linjianhang
 *
 */
@Controller
public class MainController {

	private static final Long ROLE_USER_AUTHORITY_ID = 2L;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityService authorityService;

	/**
	 * 获取index页面
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}

	/**
	 * 获取blogs页面
	 * 
	 * @return
	 */
	@GetMapping("/index")
	public String index() {
		return "redirect:/blogs";
	}

	/**
	 * 获取登录界面
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public String registerUser(User user) {
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
		user.setAuthorities(authorities);
		userService.saveUser(user);
		return "redirect:/login";
	}

	@GetMapping("/search")
	public String search() {
		return "search";
	}
}
