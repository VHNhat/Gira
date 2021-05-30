package cybersoft.javabackend.java11.gira.role.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String email;
	
	@Column(name = "role_id", insertable = false, updatable = false)
	private Long roleId;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
}
