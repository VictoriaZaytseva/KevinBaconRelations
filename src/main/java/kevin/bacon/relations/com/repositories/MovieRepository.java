package kevin.bacon.relations.com.repositories;

import kevin.bacon.relations.com.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author mh
 * @since 24.07.12
 */
// tag::repository[]
@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends GraphRepository<Movie> {
    Movie findByName(@Param("name") String name);

    @Query("MATCH p=shortestPath((bacon:Actor {name:\"Kevin Bacon\"})-[*]-(meg:Actor {name:{name}}))RETURN NODES(p)")
    Iterable<Map<String, Object>> findShortestPathTo(@Param("name") String name);

    @Query("MATCH (m:Movie)<-[:ACTED_IN]-(a:Actor) RETURN m.name as movie, collect(a.name) as cast LIMIT {limit}")
    List<Map<String,Object>> graph(@Param("limit") int limit);
}
// end::repository[]

