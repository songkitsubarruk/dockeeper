/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacoal.dockeeper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 92472
 */
@RestController
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    DataSource datasource;

    @GetMapping("/mstype")
    public ArrayList<Map<String, Object>> getMsType() throws SQLException {

        Connection con = this.datasource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("select * from ms_type");
        ArrayList<Map<String, Object>> datas = new ArrayList<>();
        while(res.next()){
            Map<String, Object>data = new HashMap<>();
            data.put("typeId", res.getString("type_id"));
            data.put("typeName", res.getString("type_name"));
            datas.add(data);
        }
        res.close();
        stmt.close();
        con.close();
        return datas;
    }

}
