package common;

public enum Constants {
	
	POSTS("posts"),
	COMMENTS("comments");
	
	String name;
	
	  Constants(String name) {
		this.name=name;
	} 
	  
	  public String getName() {
		  return name;
	  }
		
	}
	


