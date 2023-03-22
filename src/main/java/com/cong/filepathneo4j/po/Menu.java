package com.cong.filepathneo4j.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cong
 * @date 2023/3/22 17:56
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Node
public class Menu {

    @Id
    @GeneratedValue(value = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    private String name;

    @Relationship(type = "CHILDREN")
    public Set<Menu> children;

    public Menu(String name) {
        this.name=name;
    }

    public void childrenWith(Menu person) {
        if (children == null) {
            children = new HashSet<>();
        }
        children.add(person);
    }

    public String toString() {

        return this.name + "'s teammates => "
                + Optional.ofNullable(this.children).orElse(
                        Collections.emptySet()).stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
    }
}
