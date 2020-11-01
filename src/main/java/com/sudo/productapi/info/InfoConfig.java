package com.sudo.productapi.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class InfoConfig implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("info .....", 456);
	}

}
