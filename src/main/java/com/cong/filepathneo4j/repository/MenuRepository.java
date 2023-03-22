package com.cong.filepathneo4j.repository;

import com.cong.filepathneo4j.po.Menu;
import com.cong.filepathneo4j.po.Person;
import org.springframework.data.domain.Example;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface MenuRepository extends Neo4jRepository<Menu, UUID> {
 
    Person findByName(String name);
    List<Person> findByChildrenName(String name);

}