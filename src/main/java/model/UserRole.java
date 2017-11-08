package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "UserRole" database table.
 * 
 */
@Entity
@Table(name="\"UserRole\"")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String name;

	//bi-directional many-to-one association to UserRoleMap
	@OneToMany(mappedBy="userRole")
	private List<UserRoleMap> userRoleMaps;

	public UserRole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserRoleMap> getUserRoleMaps() {
		return this.userRoleMaps;
	}

	public void setUserRoleMaps(List<UserRoleMap> userRoleMaps) {
		this.userRoleMaps = userRoleMaps;
	}

	public UserRoleMap addUserRoleMap(UserRoleMap userRoleMap) {
		getUserRoleMaps().add(userRoleMap);
		userRoleMap.setUserRole(this);

		return userRoleMap;
	}

	public UserRoleMap removeUserRoleMap(UserRoleMap userRoleMap) {
		getUserRoleMaps().remove(userRoleMap);
		userRoleMap.setUserRole(null);

		return userRoleMap;
	}

}