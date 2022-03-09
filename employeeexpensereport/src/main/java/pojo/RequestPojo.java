package pojo;

public class RequestPojo {
	private int requestId;
	private int userId;
	private double requestAmount;
	private String requestDescription;
	private String requestStatus;
	public RequestPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestPojo(int requestId, int user_id, double requestAmount, String requestDescription,
			String requestStatus) {
		super();
		this.requestId = requestId;
		this.userId = user_id;
		this.requestAmount = requestAmount;
		this.requestDescription = requestDescription;
		this.requestStatus = requestStatus;
	}
	@Override
	public String toString() {
		return "RequestPojo [requestId=" + requestId + ", user_id=" + userId + ", requestAmount=" + requestAmount
				+ ", requestDescription=" + requestDescription + ", requestStatus=" + requestStatus + "]";
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int user_id) {
		this.userId = user_id;
	}
	public double getRequestAmount() {
		return requestAmount;
	}
	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
}