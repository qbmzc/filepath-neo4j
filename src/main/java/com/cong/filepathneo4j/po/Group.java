package com.cong.filepathneo4j.po;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cong
 * @date 2023/3/20 18:34
 */
@Data
@Node(labels = "Group")
public class Group {
    @Id

    private String id;
    private String name;

    @Relationship(type = "department", direction = Relationship.Direction.OUTGOING)
    private List<Department> departments=new ArrayList<>();

    public void addDepartment(Department node) {
        this.departments.add(node);
    }
}
