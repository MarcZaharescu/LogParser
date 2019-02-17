package dataUtilObjects;

/**
 *  A data class constructing the log event with the event id and the event body
 *  which contains the host, type, timestamp all encapsulated inside the Data object
 */

public class Log {


    private String id;
    private Data data;

    /** Constructor method
     *
     * @param id the event id
     * @param data the event data body
     */
    public Log(String id, Data data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
