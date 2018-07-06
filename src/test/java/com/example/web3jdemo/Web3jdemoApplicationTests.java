package com.example.web3jdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.abi.EventValues;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.model.ProjectBase;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Web3jdemoApplicationTests {

   Logger logger =  LoggerFactory.getLogger(getClass());
    Web3j web3;
    Credentials credentials;
    ProjectBase contract;
    @Test
    public void contextLoads() {
    }


    @Before
    public void initWeb3() throws IOException, CipherException {
        web3 = Web3j.build(new HttpService("https://rinkeby.infura.io/w4Ys7tFaHr9YwlS1dqvB"));
        credentials =
                WalletUtils.loadCredentials(
                        "123456789",
                        "F:/keyfile");
        logger.info("Credentials loaded");
        String address = credentials.getAddress();

        System.out.println(address);
        contract = ProjectBase.load("0x0E9EE9b450944BB318248D351f0365fbB72eb087",
                web3,credentials,BigInteger.valueOf(5_000_000_000L),BigInteger.valueOf(300000L));
        System.out.println("contract loaded");
    }
    @Test
    public void web3jConnection() throws IOException, ExecutionException, InterruptedException {
//        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
//        String clientVersion = web3ClientVersion.getWeb3ClientVersion();

        CompletableFuture<Web3ClientVersion> future = web3.web3ClientVersion().sendAsync();
        System.out.println("dosomething");
        Web3ClientVersion web3ClientVersion = future.get();
        String version = web3ClientVersion.getWeb3ClientVersion();
        System.out.println(version);
    }

    @Test
    public void useExistedContract() throws Exception {

        TransactionReceipt receipt = contract.createProject("0xb6060daeb3a0fD0AfEe80aED0e64126F3528150b",
                "projectFromIntellijIdea2", "mysteryValue").send();
       // System.out.println(receipt.getLogs());
       // EventValues eventValues = contract.processSomeEvent(receipt);
        List<ProjectBase.ProjectCreatedEventResponse> event = contract.getProjectCreatedEvents(receipt);
        for(ProjectBase.ProjectCreatedEventResponse e: event) {
            System.out.println("e.log:" + e.log);
            System.out.println("e.address_:" +e.address_);
            System.out.println("e.hashValue:" +e.hashValue);
            System.out.println("e.name:" +e.name);
        }
    }



    @Test
    public void sendAsyncRequest() throws Exception {

        CompletableFuture<TransactionReceipt> future = contract.createProject("0xb6060daeb3a0fD0AfEe80aED0e64126F3528150b",
                "projectFromIntellijIdea2", "mysteryValue").sendAsync();
        /*
        System.out.println(receipt.getLogs());
        EventValues eventValues = contract.processSomeEvent(receipt);
        */
        TransactionReceipt receipt = future.get();
        List<ProjectBase.ProjectCreatedEventResponse> event = contract.getProjectCreatedEvents(receipt);
        for(ProjectBase.ProjectCreatedEventResponse e: event) {
            System.out.println("e.log:" + e.log);
            System.out.println("e.address_:" +e.address_);
            System.out.println("e.hashValue:" +e.hashValue);
            System.out.println("e.name:" +e.name);
        }
    }
    @Test
    public void createContract() throws Exception {
        logger.info("Sending 1 Wei ("
                + Convert.fromWei("1", Convert.Unit.ETHER).toPlainString() + " Ether)");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3, credentials,
                "0x19e03255f667bdfd50a32722df860b1eeaf4d635",  // you can put any address here
                BigDecimal.ONE, Convert.Unit.WEI)  // 1 wei = 10^-18 Ether
                .send();
        logger.info("Transaction complete, view it at https://rinkeby.etherscan.io/tx/"
                + transferReceipt.getTransactionHash());

        logger.info("Deploying smart contract");
        ProjectBase contract = ProjectBase.deploy(
                web3, credentials,
                ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();

        String contractAddress = contract.getContractAddress();
        logger.info("Smart contract deployed to address " + contractAddress);
        logger.info("View contract at https://rinkeby.etherscan.io/address/" + contractAddress);
    }


    @Test
    public void retrieveValueFromContract() throws Exception {
        Tuple2<String, String> res = contract.getProject(BigInteger.valueOf(0L)).send();
        System.out.println(res);
    }


}
