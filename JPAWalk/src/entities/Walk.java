package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Walk {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private int id;

private int distance;

private int time;

private String location;

private String notes;

private boolean walked;

public int getId() {
	return id;
}


//public void setId(int id) {
//	this.id = id;
//}


public int getDistance() {
	return distance;
}


public void setDistance(int distance) {
	this.distance = distance;
}


public int getTime() {
	return time;
}


public void setTime(int time) {
	this.time = time;
}


public String getLocation() {
	return location;
}


public void setLocation(String location) {
	this.location = location;
}


public String getNotes() {
	return notes;
}


public void setNotes(String notes) {
	this.notes = notes;
}


public boolean isWalked() {
	return walked;
}


public void setWalked(boolean walked) {
	this.walked = walked;
}





@Override
public String toString() {
	return "Walk [id=" + id + ", distance=" + distance + ", time=" + time + ", location=" + location + ", notes="
			+ notes + ", walked=" + walked + "]";
}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
