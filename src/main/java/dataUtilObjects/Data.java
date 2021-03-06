package dataUtilObjects;

/**
 * a basic data class for constructing the event log body without the event id.
 *
 */
public class Data {


    private String state;
    private String type;
    private String host;
    private long timestamp;

    /** Constructor method
     *
     * @param state log state
     * @param type log type
     * @param host log host
     * @param timestamp the timestamp of them the log was generated
     */
    public Data(String state, String type, String host, long timestamp) {
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
