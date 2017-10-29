package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "OfferConstraintTypeCategory" database table.
 * 
 */
@Entity
@Table(name="\"OfferConstraintTypeCategory\"")
@NamedQuery(name="OfferConstraintTypeCategory.findAll", query="SELECT o FROM OfferConstraintTypeCategory o")
public class OfferConstraintTypeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to OfferConstraintType
	@OneToMany(mappedBy="offerConstraintTypeCategory")
	private List<OfferConstraintType> offerConstraintTypes;

	public OfferConstraintTypeCategory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OfferConstraintType> getOfferConstraintTypes() {
		return this.offerConstraintTypes;
	}

	public void setOfferConstraintTypes(List<OfferConstraintType> offerConstraintTypes) {
		this.offerConstraintTypes = offerConstraintTypes;
	}

	public OfferConstraintType addOfferConstraintType(OfferConstraintType offerConstraintType) {
		getOfferConstraintTypes().add(offerConstraintType);
		offerConstraintType.setOfferConstraintTypeCategory(this);

		return offerConstraintType;
	}

	public OfferConstraintType removeOfferConstraintType(OfferConstraintType offerConstraintType) {
		getOfferConstraintTypes().remove(offerConstraintType);
		offerConstraintType.setOfferConstraintTypeCategory(null);

		return offerConstraintType;
	}

}