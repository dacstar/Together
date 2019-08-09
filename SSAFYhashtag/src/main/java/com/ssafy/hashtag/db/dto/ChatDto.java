package com.ssafy.hashtag.db.dto;

public class ChatDto {
	private int chat_pk;
	private int opener_id;
	private String title;
	private String location;
	private String description;
	private String created_at;
	
	public ChatDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChatDto(int chat_pk, int opener_id, String title, String location, String description,
			String created_at) {
		super();
		this.chat_pk = chat_pk;
		this.opener_id = opener_id;
		this.title = title;
		this.location = location;
		this.description = description;
		this.created_at = created_at;
	}

	public int getChat_pk() {
    return chat_pk;
  }

	public void setChat_pk(int chat_pk) {
		this.chat_pk = chat_pk;
	}

	public int getOpener_id() {
		return opener_id;
	}

	public void setOpener_id(int opener_id) {
		this.opener_id = opener_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "ChatDto [chat_pk=" + chat_pk + ", opener_id=" + opener_id + ", title=" + title + ", location="
				+ location + ", description=" + description + ", created_at=" + created_at + "]";
	}
}