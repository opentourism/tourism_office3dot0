package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "OfferConstraint" database table.
 * 
 */
@Entity
@Table(name="\"OfferConstraint\"")
@NamedQuery(name="OfferConstraint.findAll", query="SELECT o FROM OfferConstraint o")
public class OfferConstraint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Offer
	@ManyToOne
	private Offer offer;

	//bi-directional many-to-one association to OfferConstraintType
	@ManyToOne
	private OfferConstraintType offerConstraintType;

	public OfferConstraint() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public OfferConstraintType getOfferConstraintType() {
		return this.offerConstraintType;
	}

	public void setOfferConstraintType(OfferConstraintType offerConstraintType) {
		this.offerConstraintType = offerConstraintType;
	}

}