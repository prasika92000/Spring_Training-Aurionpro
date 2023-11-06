package com.aurionpro.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.entity.ImageData;
import com.aurionpro.repository.StorageRepository;
import com.aurionpro.util.ImageUtil;

@Service
public class StorageService {

	// inject repo
	@Autowired
	public StorageRepository repository;

	// method to store the image 
	public String uploadImage(MultipartFile file) throws IOException {
		ImageData imageData = repository
				.save(ImageData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType()) // for image compression make imageutil class
				.imageData(ImageUtil.compressImage(file.getBytes())).build());
		
		if (imageData != null) {
			return "file uploaded successfully : " + file.getOriginalFilename();
		}
		return null;
	}

	//for downloading the image from db
	public byte[] downloadImage(String fileName) {
		Optional<ImageData> dbImageData = repository.findByName(fileName);
		byte[] images = ImageUtil.decompressImage(dbImageData.get().getImageData());
		return images;
	}

}
