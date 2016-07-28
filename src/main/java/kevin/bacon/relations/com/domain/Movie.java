package kevin.bacon.relations.com.domain;

import org.neo4j.ogm.annotation.*;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
/**
 * Class that represent movie database entity
 * @author victoria
 *
 */
public class Movie extends Node{
  
    @Relationship(type="ACTED_IN", direction = Relationship.INCOMING) private List<Actor> actors;

    public Movie() { }

    public Collection<Actor> getRoles() {
        return actors;
    }
 
    public void setRoles(List<Actor> actors) {
        this.actors = actors;
    }
    
}
