package com.github.controller;

import com.github.model.User;
import com.github.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping
public class IndexController {

	@Resource private UserService userService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping({"", "/"})
	public Object index() {

		User user = new User();
		user.setName("成都add");

		// 第1组: add
		user = userService.add(user);
		logger.info("add: " + user);

		user = userService.get(user.getId());
		logger.info("get: " + user);

		// 第2组: update
		user = userService.update(user);
		logger.info("update: " + user);

		user = userService.get(user.getId());
		logger.info("get: " + user);

		// 第3组: delete
		userService.delete(user.getId());
		logger.info("delete: " + user);
		user = userService.get(user.getId());
		logger.info("get: " + user);

		// 第4组: unless="#result eq null"  设置不缓存null, 这里会造成缓存穿透
		user = userService.getNull(2);
		logger.info("getNull: " + user);
		user = userService.get(2);
		logger.info("get: " + user);


		return "success";
	}

}
