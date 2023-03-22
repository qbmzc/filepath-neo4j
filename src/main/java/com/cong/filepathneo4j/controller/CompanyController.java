package com.cong.filepathneo4j.controller;

import com.cong.filepathneo4j.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cong
 * @date 2023/3/21 10:19
 */
@RestController
@Slf4j
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;



}
