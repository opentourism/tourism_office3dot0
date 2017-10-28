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

	@Column(name="offer_id")
	private Long offerId;

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

	public Long getOfferId() {
		return this.offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public OfferConstraintType getOfferConstraintType() {
		return this.offerConstraintType;
	}

	public void setOfferConstraintType(OfferConstraintType offerConstraintType) {
		this.offerConstraintType = offerConstraintType;
	}

}