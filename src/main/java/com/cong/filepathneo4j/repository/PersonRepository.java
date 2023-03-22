package com.cong.filepathneo4j.repository;

import com.cong.filepathneo4j.po.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, UUID> {
 
    Person findByName(String name);
    List<Person> findByTeammatesName(String name);

}