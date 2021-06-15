import java.util.ArrayList;
import java.util.List;

public class Node {
 public List<Node> sons = new ArrayList<>();
 public Node before;
 public String content ;

 public Node(Node before){
  this.before = before;
 }

 public void createSonNode(){
  this.sons.add(new Node(this));
 }
}
