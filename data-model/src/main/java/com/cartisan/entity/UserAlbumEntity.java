package com.cartisan.entity;

import com.cartisan.enums.ImageVerificationStatus;

import java.sql.Timestamp;

public class UserAlbumEntity {


	private String imageId;
	private String imageType;
	private long imageSize;
	private String imageFileName;
	private ImageVerificationStatus verificationStatus;
	private String fileSystemLocation;

	private Timestamp stampCreated;

	private Timestamp stampModified;

	public UserAlbumEntity() {
		super();
	}

	public UserAlbumEntity( String imageId, String imageFileName, String imageType, long imageSize,
                           String fileSystemLocation) {
		super();
		this.imageId = imageId;
		this.imageType = imageType;
		this.imageSize = imageSize;
		this.imageFileName = imageFileName;
		this.fileSystemLocation = fileSystemLocation;
		this.verificationStatus = ImageVerificationStatus.PENDING;
		this.stampCreated=new Timestamp(System.currentTimeMillis());
	}


	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public long getImageSize() {
		return imageSize;
	}

	public void setImageSize(long imageSize) {
		this.imageSize = imageSize;
	}

	public Timestamp getStampCreated() {
		return stampCreated;
	}

	public void setStampCreated(Timestamp stampCreated) {
		this.stampCreated = stampCreated;
	}

	public Timestamp getStampModified() {
		return stampModified;
	}

	public void setStampModified(Timestamp stampModified) {
		this.stampModified = stampModified;
	}

	public String getFileSystemLocation() {
		return fileSystemLocation;
	}

	public void setFileSystemLocation(String fileSystemLocation) {
		this.fileSystemLocation = fileSystemLocation;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public ImageVerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(ImageVerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

}
