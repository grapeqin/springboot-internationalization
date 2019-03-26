package grapple.learn.springboot.springbootinternationalization.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author grapple
 * @date 2019/3/25
 * @description
 */
@RestController
public class WebController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public Object helloworld(){
		Map<String,Object> result = new HashMap<>();
		result.put("hello",messageSource.getMessage("hello.message",null,LocaleContextHolder.getLocale()));
		result.put("name",messageSource.getMessage("hello.name",null,LocaleContextHolder.getLocale()));
		return result;
	}
}
