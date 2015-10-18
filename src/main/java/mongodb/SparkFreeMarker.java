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
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkFreeMarker {

	public static void main(String... strings) {
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFreeMarker.class, "/");

		Spark.get(new Route("/") {

			@Override
			public Object handle(Request arg0, Response arg1) {
				StringWriter stringWriter = new StringWriter();
				Template helloTemplate;
				try {
					helloTemplate = configuration
							.getTemplate("templates/hello.ftl");

					Map<String, Object> dataMap = new HashMap<String, Object>();
					dataMap.put("name", "sai ram");

					helloTemplate.process(dataMap, stringWriter);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return stringWriter;
			}

		});

	}
}
