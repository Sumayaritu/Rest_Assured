package endPoint;

import common.Constants;
import common.RestSteps;

public class Posts extends RestSteps {
	   
	public Posts() {
		init_Request();
	}
	
	public void getPosts() {
		request_GET(Constants.POSTS.getName());
	}

}
