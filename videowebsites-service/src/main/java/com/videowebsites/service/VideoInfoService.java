package com.videowebsites.service;

import java.util.List;

import com.videowebsites.entity.VideoInfo;

public interface VideoInfoService {

	public List<VideoInfo> getVideoAll(VideoInfo videoInfo);

	public int addVideo(VideoInfo videoInfo);

	public VideoInfo getVideoInfo(int id);
}
