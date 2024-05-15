package com.exampal.config;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;


@Configuration("storage")
@Getter
@Setter
public class StorageConfig {
	
	private String location = "src\\main\\resources\\static\\uploads";

	public String getLocation() {
		
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
