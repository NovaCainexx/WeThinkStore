package za.co.wethink.store.models;

/**
 * 
 * @author ebe
 *
 */
public class ControllerRestResponse {

	private String message;
	private String time;

	public ControllerRestResponse() {
		super();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String watchPrint) {
		this.time = watchPrint;
	}

	public ControllerRestResponse(String format, String watchPrint) {
		this.message = format;
		this.time = watchPrint;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
