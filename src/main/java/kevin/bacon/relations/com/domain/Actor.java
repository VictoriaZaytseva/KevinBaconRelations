package kevin.bacon.relations.com.domain;

import org.neo4j.ogm.annotation.*;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
/**
 * Class that represent movie database entity
 * @author victoria
 *
 */
public class Actor extends Node {
// empty constructor is a requirment of Neo4j
	public Actor() {
	}
}
