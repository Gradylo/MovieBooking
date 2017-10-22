package cn.tedu.mb.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
/**设置全局异常*/
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.mb.common.web.JsonResult;
@ControllerAdvice
public class ControllerException {
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonResult handleServiceException(ServiceException e){
		e.printStackTrace();
		return new JsonResult(e);
	}
	
}
