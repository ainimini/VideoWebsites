package com.videowebsites.service;
 
import com.videowebsites.entity.VideoType;
import java.util.List;

/**
 * 
 *@Desc //TODO 添加描述（视频类型查询）
 * @author dell
 *@Data  2019年3月25日 下午5:23:07
 */
public interface VideoTypeService {
	
	/**
	 * 查询所有视频类型
	 * @return
	 */
	public List<VideoType> getVideoType(VideoType videoType);
}
