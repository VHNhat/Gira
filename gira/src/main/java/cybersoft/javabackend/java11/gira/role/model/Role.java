package cybersoft.javabackend.java11.gira.role.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/* Generate getters/setters by Lombok */
@Data
/*Database connection*/
@Entity 
/* Create table */
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(insertable = false, updatable = false)
	private Long id;
	private String roleName;
	private String description;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private Set<Account> account;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	@Override
		public String toString() {
			return String.format("ROLE: %d %s %s", id, roleName, description);
		}
}
