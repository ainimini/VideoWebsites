package com.videowebsites.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videowebsites.dao.VideoInfoMapper;
import com.videowebsites.entity.VideoInfo;
import com.videowebsites.service.VideoInfoService;

@Service
public class VideoInfoServiceImpl implements VideoInfoService {
	@Autowired
	private VideoInfoMapper videoInfoMapper;

	public List<VideoInfo> getVideoAll(VideoInfo videoInfo) {
		return videoInfoMapper.getVideoAll(videoInfo);
	}

	@Override
	public int addVideo(VideoInfo videoInfo) {

		return videoInfoMapper.insert(videoInfo);
	}

	@Override
	public VideoInfo getVideoInfo(int id) {

		return videoInfoMapper.selectByPrimaryKey(id);
	}

}