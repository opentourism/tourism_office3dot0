package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "UserRoleMap" database table.
 * 
 */
@Entity
@Table(name="\"UserRoleMap\"")
@NamedQuery(name="UserRoleMap.findAll", query="SELECT u FROM UserRoleMap u")
public class UserRoleMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to UserRole
	@ManyToOne
	private UserRole userRole;

	public UserRoleMap() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}