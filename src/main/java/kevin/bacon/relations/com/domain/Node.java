package kevin.bacon.relations.com.domain;

import org.neo4j.ogm.annotation.GraphId;
/**
 * Base class with parameters for both actor and movie nodes\
 * Actor and movie are separate because neo4j actually makes difference based on the maping, plus good to know for the future
 * if additional parameters are needed
 * @author victoria
 *
 */
public class Node {
    
    @GraphId Long id;
    protected String name;
    protected String image;
   
    public Node(){}
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getImage() {
        return image;
    }
}
