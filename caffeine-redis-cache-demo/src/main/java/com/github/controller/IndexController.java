package com.github.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping
public class IndexController {

	@Resource private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping({"", "/"})
	public Object index() {

		return "success";
	}

}
