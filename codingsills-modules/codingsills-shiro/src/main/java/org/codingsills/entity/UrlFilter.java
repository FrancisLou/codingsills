package org.codingsills.entity;

import java.io.Serializable;

public class UrlFilter implements Serializable {
	private static final long serialVersionUID = 8805215746702724488L;
	private String name; // url名称/描述
	private String url; // 地址
	private String roles; // 所需要的角色，可省略
	private String permissions; // 所需要的权限，可省略

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		return true;
	}
}
