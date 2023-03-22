package com.cong.filepathneo4j.controller;

import com.cong.filepathneo4j.po.Menu;
import com.cong.filepathneo4j.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author cong
 * @date 2023/3/22 18:48
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;



    @PostMapping("save")
    public void save(){
        Menu menu = new Menu();
        menu.setName("ROOT");

        Menu home = new Menu("home");

        Menu downloads = new Menu("Downloads");

        Menu pictures = new Menu("Pictures");

        Menu videos = new Menu("Videos");

        Menu documents = new Menu("Documents");

        home.childrenWith(documents);
        home.childrenWith(downloads);
        home.childrenWith(pictures);
        home.childrenWith(videos);
        menu.childrenWith(home);
        List<Menu> menus = Arrays.asList(menu, home, documents, downloads, videos, pictures);
        menuRepository.saveAll(menus);
    }
}
