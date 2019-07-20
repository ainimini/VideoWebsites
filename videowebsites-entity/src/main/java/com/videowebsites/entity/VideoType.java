package com.videowebsites.entity;

public class VideoType {
	private Integer id;

	private String typeName;
	private String videoDel;
	private String videoUrl;
	private String videoTypeId;
	private String videoHtml;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}

	@Override
	public String toString() {
		return "VideoType [id=" + id + ", typename=" + "]";
	}
}