package org.web3j.utils;

/*
 *
 * Copyright (c) 2017-2018 Miranz Technology. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Miranz
 * technology. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Miranz.
 *
 */

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.model.ProjectBase;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;


public class Web3Handler {

    public static Web3j web3;
    public static Credentials credentials;
    public static ProjectBase contract;


    public static void initContract() throws IOException {
//        Properties p = new Properties();
//        p.load(new FileInputStream("ethereum.properties"));
        web3 = Web3j.build(new HttpService("https://rinkeby.infura.io/w4Ys7tFaHr9YwlS1dqvB"));
        try {
            credentials =
                    WalletUtils.loadCredentials(
                            "123456789",
                            "F:/keyfile");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }

        String address = credentials.getAddress();
        System.out.println(address);
        contract = ProjectBase.load("0x0E9EE9b450944BB318248D351f0365fbB72eb087",
                web3, credentials, BigInteger.valueOf(5_000_000_000L), BigInteger.valueOf(300000L));
        System.out.println("contract loaded");
    }
}