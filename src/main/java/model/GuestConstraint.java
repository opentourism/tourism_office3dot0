package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "GuestConstraint" database table.
 * 
 */
@Entity
@Table(name="\"GuestConstraint\"")
@NamedQuery(name="GuestConstraint.findAll", query="SELECT g FROM GuestConstraint g")
public class GuestConstraint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="offerconstraint_type_id")
	private Integer offerconstraintTypeId;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public GuestConstraint() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOfferconstraintTypeId() {
		return this.offerconstraintTypeId;
	}

	public void setOfferconstraintTypeId(Integer offerconstraintTypeId) {
		this.offerconstraintTypeId = offerconstraintTypeId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}