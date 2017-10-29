package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "Event" database table.
 * 
 */
@Entity
@Table(name="\"Event\"")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
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

	private String venue;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="parent_event_id")
	private Event parentEvent;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="parentEvent")
	private List<Event> events;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	private Provider provider;

	public Event() {
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

	public String getVenue() {
		return this.venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Event getParentEvent() {
		return this.parentEvent;
	}

	public void setParentEvent(Event event) {
		this.parentEvent = event;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setParentEvent(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setParentEvent(null);

		return event;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

}