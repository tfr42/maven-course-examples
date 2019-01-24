package course.example;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tf on 20.02.16.
 */
@Entity
@Table(name = "tree")
@NamedQueries({
        @NamedQuery(name = "findAllRootNodesWithTheirChildren", query = "Select n from Node as n where n.parent IS NULL"), })
public class Node {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String type;

    @ManyToOne
    @JoinColumn(name = "parent")
    private Node parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderColumn
    private List<Node> children;

    public Node() {
        this.id = null;
        this.children = new LinkedList<>();
        this.name = "";
    }

    public Node(String name) {
        this();
        this.name = name;
    }

    public Node(String name, String type) {
        this(name);
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void addChild(Node childNode) {
        this.children.add(childNode);
        childNode.setParent(this);
    }

    public void addChild(Node... childNodes) {
        for (Node child : childNodes) {
            this.addChild(child);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        String path = "";
        if (parent != null) {
            path = parent.getPath();
        }
        path = path + "/" + name;
        return path;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean hasParent() {
        return this.parent == null;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + ", name='" + name + '\'' + ", type='" + type + '\'' + ", path=" + getPath() + '}';
    }
}
