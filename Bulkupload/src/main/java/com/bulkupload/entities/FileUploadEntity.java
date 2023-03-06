package com.bulkupload.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "file_upload")
public class FileUploadEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "filename")
	private String filename;

	@Column(name = "mimetype")
	private String mimetype;

	@Column(name = "encoding")
	private String encoding;

	@Column(name = "size")
	private Long size;

	@Column(name = "original_name")
	private String originalName;

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public FileUploadEntity(Long id, String mimetype, String encoding, Long size, String originalName, boolean isActive,
			Date createdAt) {
		super();
		this.id = id;
		this.mimetype = mimetype;
		this.encoding = encoding;
		this.size = size;
		this.originalName = originalName;

		this.createdAt = createdAt;
	}

	public FileUploadEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
