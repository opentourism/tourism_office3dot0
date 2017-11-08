package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "GuestPreference" database table.
 * 
 */
@Entity
@Table(name="\"GuestPreference\"")
@NamedQuery(name="GuestPreference.findAll", query="SELECT g FROM GuestPreference g")
public class GuestPreference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to OfferCategory
	@ManyToOne
	private OfferCategory offerCategory;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public GuestPreference() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OfferCategory getOfferCategory() {
		return this.offerCategory;
	}

	public void setOfferCategory(OfferCategory offerCategory) {
		this.offerCategory = offerCategory;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}