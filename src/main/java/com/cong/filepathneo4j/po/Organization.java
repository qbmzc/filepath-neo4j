package com.cong.filepathneo4j.po;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cong
 * @date 2023/3/20 18:30
 */
@Data
@Node(labels = "Organization")
public class Organization {

    @Id
    private String id;

    private String name;

    @Relationship(type = "group",direction = Relationship.Direction.OUTGOING)
    private List<Group> groups =new ArrayList<>();
    public   void addGroup(Group group){
        this.groups.add(group);
    }
}
