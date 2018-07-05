package com.cartisan.response;

import com.cartisan.entity.UserAlbumEntity;
import com.cartisan.enums.ImageVerificationStatus;
import com.cartisan.util.Util;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAlbumEntityResponse implements ApiResponse {

	protected UserAlbumEntity albumEntity;
	private String imageId;
	private String servingLocation;
	private ImageVerificationStatus verificationStatus;

	public UserAlbumEntityResponse(){}

	public UserAlbumEntityResponse(UserAlbumEntity albumEntity) {
		super();
		this.imageId = albumEntity.getImageId();
		if (!Util.isNullOrEmpty(albumEntity.getFileSystemLocation()))
			this.servingLocation = albumEntity.getFileSystemLocation();
		else
			this.servingLocation = "dummy" + albumEntity.getImageFileName();
		this.verificationStatus = albumEntity.getVerificationStatus();
		this.albumEntity = albumEntity;
	}

	public String getImageId() {
		return imageId;
	}

	public String getServingLocation() {
		return servingLocation;
	}

	public ImageVerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	@JsonIgnore
	public UserAlbumEntity getAlbumEntity() {
		return albumEntity;
	}

	@JsonIgnore
	public void setAlbumEntity(UserAlbumEntity albumEntity) {
		this.albumEntity = albumEntity;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setServingLocation(String servingLocation) {
		this.servingLocation = servingLocation;
	}

	public void setVerificationStatus(ImageVerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
}
