package cybersoft.javabackend.java11.gira.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_role_group")
public class RoleGroup extends AbstractEntity{
	@NotBlank(message = "Role name can't be blank.")
	@Length(min = 4, max = 50, message = "Role name length is between {0} and {1}.")
	private String groupName;
	
	@NotBlank(message = "Role description can't be blank.")
	private String description;
	
	/*
	 * Quan hệ Many to Many
	 * - sử dụng Set, không sử dụng List
	 * - không sử dụng cascade REMOVE và ALL
	 * - tạo bảng join table ở đối tượng chính
	 */
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "gira_group_role_link",
				joinColumns = @JoinColumn(name = "group_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "gira_user_role_group",
				joinColumns = @JoinColumn(name = "role_group_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonIgnore
	private Set<User> users = new HashSet<>();
	
	/*
	 * Helper methods
	 * để đảm bảo dữ liệu luôn được thống nhất giữa các đối tượng
	 * 
	 */
	public RoleGroup addRole(Role role) {
		this.roles.add(role);
		role.getGroups().add(this);
		return this;
	}
	
	public RoleGroup name(String name) {
		this.groupName = name;
		return this;
	}
	
	public RoleGroup description(String description) {
		this.description = description;
		return this;
	}

	/* getters, setters */
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
