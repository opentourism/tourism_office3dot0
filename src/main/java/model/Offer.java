package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "Offer" database table.
 * 
 */
@Entity
@Table(name="\"Offer\"")
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(name="end_date")
	private Timestamp endDate;

	private String name;

	@Column(name="start_date")
	private Timestamp startDate;

	private String url;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to OfferCategory
	@ManyToOne
	@JoinColumn(name="offercategory_id")
	private OfferCategory offerCategory;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumn(name="provider_id")
	private Provider provider;

	//bi-directional many-to-one association to OfferConstraint
	@OneToMany(mappedBy="offer")
	private List<OfferConstraint> offerConstraints;

	public Offer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public OfferCategory getOfferCategory() {
		return this.offerCategory;
	}

	public void setOfferCategory(OfferCategory offerCategory) {
		this.offerCategory = offerCategory;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<OfferConstraint> getOfferConstraints() {
		return this.offerConstraints;
	}

	public void setOfferConstraints(List<OfferConstraint> offerConstraints) {
		this.offerConstraints = offerConstraints;
	}

	public OfferConstraint addOfferConstraint(OfferConstraint offerConstraint) {
		getOfferConstraints().add(offerConstraint);
		offerConstraint.setOffer(this);

		return offerConstraint;
	}

	public OfferConstraint removeOfferConstraint(OfferConstraint offerConstraint) {
		getOfferConstraints().remove(offerConstraint);
		offerConstraint.setOffer(null);

		return offerConstraint;
	}

}