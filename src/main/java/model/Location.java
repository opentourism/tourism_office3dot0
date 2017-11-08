package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Location" database table.
 * 
 */
@Entity
@Table(name="\"Location\"")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Object coordinates;

	private String guid;

	private String name;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="location")
	private List<Event> events;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="location")
	private List<Offer> offers;

	//bi-directional many-to-one association to Provider
	@OneToMany(mappedBy="location")
	private List<Provider> providers;

	public Location() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Object getCoordinates() {
		return this.coordinates;
	}

	public void setCoordinates(Object coordinates) {
		this.coordinates = coordinates;
	}

	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setLocation(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setLocation(null);

		return event;
	}

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Offer addOffer(Offer offer) {
		getOffers().add(offer);
		offer.setLocation(this);

		return offer;
	}

	public Offer removeOffer(Offer offer) {
		getOffers().remove(offer);
		offer.setLocation(null);

		return offer;
	}

	public List<Provider> getProviders() {
		return this.providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public Provider addProvider(Provider provider) {
		getProviders().add(provider);
		provider.setLocation(this);

		return provider;
	}

	public Provider removeProvider(Provider provider) {
		getProviders().remove(provider);
		provider.setLocation(null);

		return provider;
	}

}