package mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class FreeMarker {
	public static void main(String...strings) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException{
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(FreeMarker.class, "/");
		
		Template helloTemplate = configuration.getTemplate("templates/hello.ftl");
		StringWriter stringWriter = new StringWriter();
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put("name", "sai ram");
		
		helloTemplate.process(dataMap, stringWriter);
		System.out.println(stringWriter);
	}

}
