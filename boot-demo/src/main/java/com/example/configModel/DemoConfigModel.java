package com.example.configModel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix="boot.demo")
public class DemoConfigModel {

	public String payeeNameLabel;
	
	public String payeeTypeLabel;
	
	public String getPayeeNameLabel() {
		return payeeNameLabel;
	}

	public void setPayeeNameLabel(String payeeNameLabel) {
		this.payeeNameLabel = payeeNameLabel;
	}

	public String getPayeeTypeLabel() {
		return payeeTypeLabel;
	}

	public void setPayeeTypeLabel(String payeeTypeLabel) {
		this.payeeTypeLabel = payeeTypeLabel;
	}

	
}
