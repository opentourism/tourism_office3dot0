package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "OfferConstraintType" database table.
 * 
 */
@Entity
@Table(name="\"OfferConstraintType\"")
@NamedQuery(name="OfferConstraintType.findAll", query="SELECT o FROM OfferConstraintType o")
public class OfferConstraintType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to OfferConstraint
	@OneToMany(mappedBy="offerConstraintType")
	private List<OfferConstraint> offerConstraints;

	//bi-directional many-to-one association to OfferConstraintTypeCategory
	@ManyToOne
	private OfferConstraintTypeCategory offerConstraintTypeCategory;

	public OfferConstraintType() {
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

	public List<OfferConstraint> getOfferConstraints() {
		return this.offerConstraints;
	}

	public void setOfferConstraints(List<OfferConstraint> offerConstraints) {
		this.offerConstraints = offerConstraints;
	}

	public OfferConstraint addOfferConstraint(OfferConstraint offerConstraint) {
		getOfferConstraints().add(offerConstraint);
		offerConstraint.setOfferConstraintType(this);

		return offerConstraint;
	}

	public OfferConstraint removeOfferConstraint(OfferConstraint offerConstraint) {
		getOfferConstraints().remove(offerConstraint);
		offerConstraint.setOfferConstraintType(null);

		return offerConstraint;
	}

	public OfferConstraintTypeCategory getOfferConstraintTypeCategory() {
		return this.offerConstraintTypeCategory;
	}

	public void setOfferConstraintTypeCategory(OfferConstraintTypeCategory offerConstraintTypeCategory) {
		this.offerConstraintTypeCategory = offerConstraintTypeCategory;
	}

}