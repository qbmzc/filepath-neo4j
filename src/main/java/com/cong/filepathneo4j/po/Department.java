package com.cong.filepathneo4j.po;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cong
 * @date 2023/3/20 18:35
 */
@Data
@Node(labels = "Department")
public class Department {
    @Id
    private String id;
    private String name;

    @Relationship(type = "department", direction = Relationship.Direction.OUTGOING)
    private List<Department> departments=new ArrayList<>();
    @Relationship(type = "employee", direction = Relationship.Direction.OUTGOING)
    private List<Employee> employees=new ArrayList<>();

    public void addDepartment(Department node) {
        this.departments.add(node);
    }

    public void addEmployee(Employee node) {
        this.employees.add(node);
    }
}
