package org.web3j.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.utils.Web3Handler;

import java.io.IOException;
import java.math.BigInteger;

@Service
public class ContractService {

    public ContractService() throws IOException {
        Web3Handler.initContract();
    }

    public Tuple2<String, String> getProjectById(@RequestParam(value = "id", defaultValue = "0") int id) throws Exception {
        Tuple2<String, String> res = Web3Handler.contract.getProject(BigInteger.valueOf(id)).send();
        return res;
    }
}
