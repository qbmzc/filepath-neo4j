package com.cong.filepathneo4j.pojo;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author cong
 * @date 2023/3/20 18:37
 */
@Data
@Node(labels = "Employee")
public class Employee {
    @Id
    private String id;
    private String userId;
    private String name;
}
