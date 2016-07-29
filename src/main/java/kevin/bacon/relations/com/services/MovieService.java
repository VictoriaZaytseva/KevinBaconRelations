package kevin.bacon.relations.com.services;

import kevin.bacon.relations.com.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class MovieService {

   @Autowired MovieRepository movieRepository;
   private ArrayList<Object> format(Iterator<Map<String, Object>> result) {
	   if(result.hasNext())
	   	   return (ArrayList<Object>) result.next().get("NODES(p)");
	   else 
		   return new ArrayList<Object>();
    }

    public ArrayList<Object> graph(String name) {
        Iterator<Map<String, Object>> result = movieRepository.findShortestPathTo(name).iterator();
        return format(result);
    }
}
