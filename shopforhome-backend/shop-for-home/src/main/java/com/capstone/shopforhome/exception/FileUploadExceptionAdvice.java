package com.capstone.shopforhome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capstone.shopforhome.message.ResponseMessage;



/*
 * @Author:Vignesh
 * Modified Date:30-08-2022
 * Description:This class is responsible for Bulk upload Exception.
 */



@ControllerAdvice
public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
	  }
}
