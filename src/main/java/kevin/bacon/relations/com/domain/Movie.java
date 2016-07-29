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
// empty constructor is a requirment of neo4j  
    public Movie() { }  
}
