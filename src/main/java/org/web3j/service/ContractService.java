package org.web3j.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.utils.Web3Handler;

import java.io.IOException;
import java.math.BigInteger;


public class ContractService {

    public ContractService() throws IOException {
        Web3Handler.initContract();
    }

    public Tuple2<String, String> getProjectById(int id) throws Exception {
        Tuple2<String, String> res = Web3Handler.contract.getProject(BigInteger.valueOf(id)).send();
        return res;
    }
}
