package com.cong.filepathneo4j.service;

import com.cong.filepathneo4j.po.Department;
import com.cong.filepathneo4j.po.Employee;
import com.cong.filepathneo4j.po.Group;
import com.cong.filepathneo4j.po.Organization;
import com.cong.filepathneo4j.repository.DepartmentRepository;
import com.cong.filepathneo4j.repository.EmployeeRepository;
import com.cong.filepathneo4j.repository.GroupRepository;
import com.cong.filepathneo4j.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author cong
 * @date 2023/3/21 10:04
 */
@Service
public class CompanyService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private OrganizationRepository organizationRepository;


    @Autowired
    private EmployeeRepository employeeRepository;


    public String createOrg(String name){
        Organization organization = new Organization();
        organization.setName(name);
        organization.setId(UUID.randomUUID().toString());
        organizationRepository.save(organization);
        return organization.getId();
    }


    /**
     *
     * @param id 组织ID
     * @param name group名称
     * @return
     */
    public String createGroup(String id,String name){
        Group group = new Group();
        group.setName(name);
        group.setId(UUID.randomUUID().toString());
        groupRepository.save(group);
        Optional<Organization> optional = organizationRepository.findById(id);
        if (optional.isPresent()){
            Organization organization = optional.get();
            organization.addGroup(group);
            organizationRepository.save(organization);
        }

        return group.getId();

    }

    public String createDep(String id,String name){
        Department department = new Department();
        department.setName(name);
        department.setId(UUID.randomUUID().toString());

        Optional<Group> byId = groupRepository.findById(id);
        if (byId.isPresent()){
            Group group = byId.get();
            group.addDepartment(department);
            groupRepository.save(group);

        }
        return department.getId();
    }

    public String createEmp(String id,String name){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setId(UUID.randomUUID().toString());

        Optional<Department> byId = departmentRepository.findById(id);
        if (byId.isPresent()){
            Department department = byId.get();
            department.addEmployee(employee);
            departmentRepository.save(department);
        }
        return employee.getId();


    }
}
