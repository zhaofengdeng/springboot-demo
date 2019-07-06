package com.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.ebean.Ebean;
import io.ebean.annotation.DbComment;

@Entity
@Table(name = "tbl_user_detail")
@DbComment("用户表详细表")
public class UserDetail {
	@Id
	@Column(name = "id", nullable = false)
	@DbComment("唯一id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@DbComment("用户")
	private User user;

	@DbComment("名称")
	@Column(name = "name")
	private String name;

	@Column(name = "inserted_at")
	@DbComment("创建日期")
	private Date insertedAt;

	@Column(name = "inserter")
	@DbComment("创建人")
	private String inserter;

	@Column(name = "updated_at")
	@DbComment("修改时间")
	private Date updatedAt;

	@Column(name = "updater")
	@DbComment("修改人")
	private String updater;

	@Column(name = "deleted")
	private Boolean deleted;

	public void save() {
		this.setDeleted(false);
		this.setUpdatedAt(new Date());
		this.setInsertedAt(new Date());
		Ebean.save(this);
	}

	public void update() {
		this.setUpdatedAt(new Date());
		Ebean.save(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

	public String getInserter() {
		return inserter;
	}

	public void setInserter(String inserter) {
		this.inserter = inserter;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
