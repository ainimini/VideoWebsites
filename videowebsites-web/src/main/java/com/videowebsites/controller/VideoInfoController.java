
package com.videowebsites.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.videowebsites.entity.VideoInfo;
import com.videowebsites.service.VideoInfoService;
import com.videowebsites.service.VideoTypeService;

@Controller
public class VideoInfoController {
	private static Logger log = Logger.getLogger(VideoInfoController.class);
	@Autowired
	private VideoInfoService videoInfoService;
	@Autowired
	private VideoTypeService videoTypeService;
	private static final String INDEXVIDEO = "indexVideo";
	private static final String LOCAADDVIDEO = "locaAddVideo";
	private static final String GETVIDEO = "getVideo";

	/**
	 * 查询所有的视频
	 * 
	 * @param request
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping("/indexVideo")
	public String indexVideo(HttpServletRequest request, Integer pageIndex) {
		// 页数 一定要在调用dao 方法之前。 1 变为0 2 2 （页面-1）*2
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Page startPage = PageHelper.startPage(pageIndex, 3);
		request.setAttribute("listVideo", videoInfoService.getVideoAll(null));
		// 分页总数
		request.setAttribute("pages", startPage.getPages());
		return INDEXVIDEO;
	}

	@RequestMapping("/locaVideo")
	public String locaAddVideo(HttpServletRequest request) {
		request.setAttribute("listVideoType", videoTypeService.getVideoType(null));
		return LOCAADDVIDEO;
	}

	@RequestMapping("/addVideo")
	public String addVideo(@RequestParam(value = "file", required = false) MultipartFile file, VideoInfo videoInfo,
			HttpServletRequest request) {
		String imgName = System.currentTimeMillis() + ".png";
		// 项目环境地址
		String path = request.getSession().getServletContext().getRealPath("/static/imgs");
		log.info("path:" + path);
		File targetFile = new File(path, imgName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();// 创建文件夹
		}
		// 保存图片
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			log.error(e);
			request.setAttribute("result", "上传图片失败!");
			return LOCAADDVIDEO;
		}
		videoInfo.setVideoUrl(imgName);
		try {
			log.info("###videoInfoService start.. addVideo()###videoInfo:" + videoInfo.toString() + " ");
			int addresult = videoInfoService.addVideo(videoInfo);
			log.info("###videoInfoService end.. addVideo()### addresult={}" + addresult);

			if (addresult <= 0) {
				request.setAttribute("result", "保存数据错误!");
				return LOCAADDVIDEO;
			}
			return "redirect:/indexVideo";
		} catch (Exception e) {
			log.error(e);
			request.setAttribute("result", "保存数据错误!");
			return LOCAADDVIDEO;
		}

	}

	@RequestMapping("/getVideo")
	public String getVideo(Integer id, HttpServletRequest request) {
		VideoInfo videoInfo = videoInfoService.getVideoInfo(id);
		request.setAttribute("videoInfo", videoInfo);
		return GETVIDEO;
	}
}
