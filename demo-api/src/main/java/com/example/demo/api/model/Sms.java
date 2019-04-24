package com.example.demo.api.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class Sms implements Serializable {
	
	private List<String> receivers;
	private String message;
	private String sender;
}
