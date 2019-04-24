package com.example.demo.api.util;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class SlackNotifyUtil {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class SlackMessageAttachement {
		private String webHookUrl;
		private String channel;		
		private String color;
		private String pretext;
		private String title;
		private String title_link;
		private String text;			
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class SlackMessage {
		private String text;
		private String channel;
		private List<SlackMessageAttachement> attachments;

		void addAttachment(SlackMessageAttachement attachement) {
			if (this.attachments == null) {
				this.attachments = Lists.newArrayList();
			}
			this.attachments.add(attachement);
		}
	}

	public int notify(SlackMessageAttachement message) {
		log.debug("Notify[message: {}]", message);
		
		SlackMessage slackMessage = SlackMessage.builder().channel(message.getChannel())
				.attachments(Lists.newArrayList(message)).build();

		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForEntity(message.getWebHookUrl(), slackMessage, String.class);
			return 1;
		} catch (Exception e) {
			log.error("Occur Exception: {}", e);
			return -1;
		}
	}
}