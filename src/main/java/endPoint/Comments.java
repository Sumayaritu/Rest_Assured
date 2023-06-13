package endPoint;

import common.Constants;
import common.RestSteps;

public class Comments extends RestSteps {
	
	public Comments() {
		init_Request();
	}
	
	public void get_Comments() {
		request_GET(Constants.COMMENTS.getName());
	}

}
