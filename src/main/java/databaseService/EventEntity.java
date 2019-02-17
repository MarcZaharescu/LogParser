package databaseService;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Event", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class EventEntity implements Serializable {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private String eventId;
    @Column(name = "DURATION", unique = false, nullable = false, length = 100)
    private int duration;
    @Column(name = "TYPE", unique = false, nullable = true, length = 100)
    private String type;
    @Column(name = "HOST", unique = false, nullable = true, length = 100)
    private String host;
    @Column(name = "ALERT", unique = false, nullable = true, length = 100)
    private boolean alert;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean getAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }
}