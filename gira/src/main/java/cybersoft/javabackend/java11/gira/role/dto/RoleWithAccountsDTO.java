package cybersoft.javabackend.java11.gira.role.dto;

import java.util.Set;

import cybersoft.javabackend.java11.gira.role.model.Account;

public class RoleWithAccountsDTO {
	/*
	 *  Data Transfer Object
	 * */
	private long id;
	private String roleName;
	private String description;
	private Set<Account> account;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	
	
}
