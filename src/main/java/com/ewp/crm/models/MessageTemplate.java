package com.ewp.crm.models;

import javax.persistence.*;

@Entity
@Table
public class MessageTemplate {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String name;

	@Lob
	private String templateText;

	@Lob
	private String otherText;

	public MessageTemplate() {
	}

	public MessageTemplate(String name, String templateText, String otherText) {
		this.name = name;
		this.templateText = templateText;
		this.otherText = otherText;
	}

	public MessageTemplate(String name, String templateText) {
		this.name = name;
		this.templateText = templateText;
	}

	public Long getId() {

		return id;
	}

	public String getOtherText() {
		return otherText;
	}

	public void setOtherText(String otherText) {
		this.otherText = otherText;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplateText() {
		return templateText;
	}

	public void setTemplateText(String templateText) {
		this.templateText = templateText;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MessageTemplate that = (MessageTemplate) o;

		if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
		if (getTemplateText() != null ? !getTemplateText().equals(that.getTemplateText()) : that.getTemplateText() != null)
			return false;
		return getOtherText() != null ? getOtherText().equals(that.getOtherText()) : that.getOtherText() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + (getTemplateText() != null ? getTemplateText().hashCode() : 0);
		result = 31 * result + (getOtherText() != null ? getOtherText().hashCode() : 0);
		return result;
	}
}
