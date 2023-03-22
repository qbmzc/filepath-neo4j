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
public class Person {

    @Id
    @GeneratedValue(value = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    private String name;

    @Relationship(type = "TEAMMATE")
    public Set<Person> teammates;

    public Person(String name) {
        this.name=name;
    }

    public void worksWith(Person person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    public String toString() {

        return this.name + "'s teammates => "
                + Optional.ofNullable(this.teammates).orElse(
                        Collections.emptySet()).stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}
