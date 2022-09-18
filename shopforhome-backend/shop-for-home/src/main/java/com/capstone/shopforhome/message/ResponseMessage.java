package com.capstone.shopforhome.message;


/*
 * @Author:Vignesh
 * Modified Date:30-08-2022
 * Description:This Entity class returns the response message regarding the status of csv.
 */

public class ResponseMessage {

	 private String message;
	  public ResponseMessage(String message) {
	    this.message = message;
	  }
	  public String getMessage() {
	    return message;
	  }
	  public void setMessage(String message) {
	    this.message = message;
	  }
}
