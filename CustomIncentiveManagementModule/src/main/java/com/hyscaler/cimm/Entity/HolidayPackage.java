package com.hyscaler.cimm.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="HOLIDAY_PKG")
public class HolidayPackage {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 	
	    @Column(length=25)
	    private String holidayName;
	    
	    private Integer duration;
	    @Column(length=25)
	    private String destination;
	    @Column(length=25)
	    private String location;
	    
	    private Integer amenities;
	    
	    
	    
		public HolidayPackage() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		public HolidayPackage(Integer id, String holidayName, Integer duration, String destination, String location,
				Integer amenities) {
			super();
			this.id = id;
			this.holidayName = holidayName;
			this.duration = duration;
			this.destination = destination;
			this.location = location;
			this.amenities = amenities;
		}



		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getHolidayName() {
			return holidayName;
		}
		public void setHolidayName(String holidayName) {
			this.holidayName = holidayName;
		}
		public Integer getDuration() {
			return duration;
		}
		public void setDuration(Integer duration) {
			this.duration = duration;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Integer getAmenities() {
			return amenities;
		}
		public void setAmenities(Integer amenities) {
			this.amenities = amenities;
		}
	    
	    
	    
	    

}
