package com.videowebsites.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videowebsites.entity.VideoType;
import com.videowebsites.service.VideoTypeService;

/**
 * 
 * @Desc //TODO 添加描述（）
 * @author dell
 * @Data 2019年3月24日 下午9:55:53
 */
@Controller
public class TestController {

	private static Logger log = Logger.getLogger(TestController.class);
	private static final String TEST = "test";
	@Autowired
	private VideoTypeService videoTypeService;

	@RequestMapping("/hello")
	public String hello() {
		return TEST;
	}

	/**
	 * 提高一个返回json格式 查询所有VideoType
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getVideoTypeList")
	public List<VideoType> getVideoTypeList() {
		List<VideoType> ListVideotype = videoTypeService.getVideoType(null);
		for (VideoType vt : ListVideotype) {
			log.info(vt.toString());
		}
		return ListVideotype;

	}
}