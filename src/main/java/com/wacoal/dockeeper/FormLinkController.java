/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacoal.dockeeper;

import javax.sql.DataSource;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 92472
 */
@RestController
public class FormLinkController {

    @Autowired
    DataSource datasource;

    @GetMapping("/formlink")
    public ModelAndView index() {
        return new ModelAndView("formlink");
    }

    @PostMapping("/reports")
    public ModelAndView viewReports(
            final ModelMap modelMap,
            ModelAndView view,
//                        @PathParam("reportname") String reportname,
            @RequestParam("reportname") String reportname,
            @RequestParam("format") String format,
            @RequestParam("typeId") String typeId
    ) {

        modelMap.put("datasource", this.datasource);
        modelMap.put("format", format);
        modelMap.put("p_type_id", typeId);
        view = new ModelAndView("main/reports/"+reportname, modelMap);

        return view;
    }

}
