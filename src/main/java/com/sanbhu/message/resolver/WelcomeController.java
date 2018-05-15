package com.sanbhu.message.resolver;

import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanbhu.message.resolver.confg.WebConfiguration;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		try(final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();){
			annotationConfigApplicationContext.register(WebConfiguration.class);
			annotationConfigApplicationContext.refresh();
			MessageSource messageSource = annotationConfigApplicationContext.getBean(MessageSource.class);
			String message = messageSource.getMessage("application.name.key", new Object[] { 28,"Bhushan Patil" }, Locale.US);
			model.put("message", message);
		}
		return "welcome";
	}

}