package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "OfferCategory" database table.
 * 
 */
@Entity
@Table(name="\"OfferCategory\"")
@NamedQuery(name="OfferCategory.findAll", query="SELECT o FROM OfferCategory o")
public class OfferCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String name;

	//bi-directional many-to-one association to GuestPreference
	@OneToMany(mappedBy="offerCategory")
	private List<GuestPreference> guestPreferences;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="offerCategory")
	private List<Offer> offers;

	//bi-directional many-to-one association to OfferCategory
	@ManyToOne
	@JoinColumn(name="parent_offercategory_id")
	private OfferCategory parentOfferCategory;

	//bi-directional many-to-one association to parentOfferCategory
	@OneToMany(mappedBy="parentOfferCategory")
	private List<OfferCategory> offerCategories;

	public OfferCategory() {
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

	public List<GuestPreference> getGuestPreferences() {
		return this.guestPreferences;
	}

	public void setGuestPreferences(List<GuestPreference> guestPreferences) {
		this.guestPreferences = guestPreferences;
	}

	public GuestPreference addGuestPreference(GuestPreference guestPreference) {
		getGuestPreferences().add(guestPreference);
		guestPreference.setOfferCategory(this);

		return guestPreference;
	}

	public GuestPreference removeGuestPreference(GuestPreference guestPreference) {
		getGuestPreferences().remove(guestPreference);
		guestPreference.setOfferCategory(null);

		return guestPreference;
	}

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Offer addOffer(Offer offer) {
		getOffers().add(offer);
		offer.setOfferCategory(this);

		return offer;
	}

	public Offer removeOffer(Offer offer) {
		getOffers().remove(offer);
		offer.setOfferCategory(null);

		return offer;
	}

	public OfferCategory getParentOfferCategory() {
		return this.parentOfferCategory;
	}

	public void setParentOfferCategory(OfferCategory offerCategory) {
		this.parentOfferCategory = offerCategory;
	}

	public List<OfferCategory> getOfferCategories() {
		return this.offerCategories;
	}

	public void setOfferCategories(List<OfferCategory> offerCategories) {
		this.offerCategories = offerCategories;
	}

	public OfferCategory addOfferCategory(OfferCategory offerCategory) {
		getOfferCategories().add(offerCategory);
		offerCategory.setParentOfferCategory(this);

		return offerCategory;
	}

	public OfferCategory removeOfferCategory(OfferCategory offerCategory) {
		getOfferCategories().remove(offerCategory);
		offerCategory.setParentOfferCategory(null);

		return offerCategory;
	}

}