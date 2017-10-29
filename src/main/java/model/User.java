package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "User" database table.
 * 
 */
@Entity
@Table(name="\"User\"")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String email;

	private String firstname;

	private String gender;

	private String lastname;

	@Column(name="mobilephone_nr")
	private Integer mobilephoneNr;

	@Column(name="password_hash")
	private String passwordHash;

	//bi-directional many-to-one association to GuestConstraint
	@OneToMany(mappedBy="user")
	private List<GuestConstraint> guestConstraints;

	//bi-directional many-to-one association to GuestPreference
	@OneToMany(mappedBy="user")
	private List<GuestPreference> guestPreferences;

	//bi-directional many-to-one association to UserRoleMap
	@OneToMany(mappedBy="user")
	private List<UserRoleMap> userRoleMaps;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getMobilephoneNr() {
		return this.mobilephoneNr;
	}

	public void setMobilephoneNr(Integer mobilephoneNr) {
		this.mobilephoneNr = mobilephoneNr;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<GuestConstraint> getGuestConstraints() {
		return this.guestConstraints;
	}

	public void setGuestConstraints(List<GuestConstraint> guestConstraints) {
		this.guestConstraints = guestConstraints;
	}

	public GuestConstraint addGuestConstraint(GuestConstraint guestConstraint) {
		getGuestConstraints().add(guestConstraint);
		guestConstraint.setUser(this);

		return guestConstraint;
	}

	public GuestConstraint removeGuestConstraint(GuestConstraint guestConstraint) {
		getGuestConstraints().remove(guestConstraint);
		guestConstraint.setUser(null);

		return guestConstraint;
	}

	public List<GuestPreference> getGuestPreferences() {
		return this.guestPreferences;
	}

	public void setGuestPreferences(List<GuestPreference> guestPreferences) {
		this.guestPreferences = guestPreferences;
	}

	public GuestPreference addGuestPreference(GuestPreference guestPreference) {
		getGuestPreferences().add(guestPreference);
		guestPreference.setUser(this);

		return guestPreference;
	}

	public GuestPreference removeGuestPreference(GuestPreference guestPreference) {
		getGuestPreferences().remove(guestPreference);
		guestPreference.setUser(null);

		return guestPreference;
	}

	public List<UserRoleMap> getUserRoleMaps() {
		return this.userRoleMaps;
	}

	public void setUserRoleMaps(List<UserRoleMap> userRoleMaps) {
		this.userRoleMaps = userRoleMaps;
	}

	public UserRoleMap addUserRoleMap(UserRoleMap userRoleMap) {
		getUserRoleMaps().add(userRoleMap);
		userRoleMap.setUser(this);

		return userRoleMap;
	}

	public UserRoleMap removeUserRoleMap(UserRoleMap userRoleMap) {
		getUserRoleMaps().remove(userRoleMap);
		userRoleMap.setUser(null);

		return userRoleMap;
	}

}