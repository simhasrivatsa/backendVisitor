package com.vistorCount.http;

import org.springframework.web.multipart.MultipartFile;

public class ImageStoreRequest {

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public long getContentLenth() {
		return contentLenth;
	}

	public void setContentLenth(long contentLenth) {
		this.contentLenth = contentLenth;
	}

	private String imageFileName;
	private MultipartFile imageFile;
	private long contentLenth;

	public ImageStoreRequest(String imageFileName, MultipartFile imageFile, long contentLength) {
		super();
		this.imageFileName = imageFileName;
		this.imageFile = imageFile;
		this.contentLenth = contentLength;
	}



}
