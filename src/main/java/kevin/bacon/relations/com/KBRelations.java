package kevin.bacon.relations.com;

import kevin.bacon.relations.com.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Controller
@Configuration
@Import(MyNeo4jConfiguration.class)
public class KBRelations extends WebMvcConfigurerAdapter {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(KBRelations.class, args);
    }

    @Autowired
    MovieService movieService;

	@RequestMapping(value = "/path", method = { RequestMethod.GET })
	public @ResponseBody ArrayList<Object> path(@RequestParam String n) {
        return movieService.graph(n);
    }
	
    @RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		String message = "Weclome to the awesome search page!";
		return new ModelAndView("welcome", "message", message);
	}

}
