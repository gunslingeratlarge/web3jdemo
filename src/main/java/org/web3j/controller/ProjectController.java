package org.web3j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.model.Project;
import org.web3j.tuples.generated.Tuple2;

@RestController
public class ProjectController {

    private ContractService cs;

    @Autowired
    public ProjectController(ContractService cs) {
        this.cs = cs;
    }

    @RequestMapping("/getProjectById")
    public String getProjectById(@RequestParam(value = "id", defaultValue = "0") int id) throws Exception {
        try {
            Tuple2<String, String> res = cs.getProjectById(id);
            Project p = new Project();
            p.setName(res.getValue1());
            p.setHashValue(res.getValue2());
            return p.toString();
        } catch(IndexOutOfBoundsException e) {
            return "index越界";
        }

    }


}
