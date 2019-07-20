package com.videowebsites.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videowebsites.dao.VideoTypeMapper;
import com.videowebsites.entity.VideoType;
import com.videowebsites.service.VideoTypeService;

@Service
public class VideoTypeServiceImpl implements VideoTypeService {
	@Autowired
	private VideoTypeMapper VideoTypeMapper;

	@Override
	public List<VideoType> getVideoType(VideoType videoType) {
		return VideoTypeMapper.getVideoType(videoType);
	}

}
