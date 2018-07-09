package org.web3j.model;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class ProjectBase extends Contract {
    public static final String FUNC_CHANGEHASHVALUE = "changeHashValue";
    public static final String FUNC_PROJECTIDTOSELLER = "projectIdToSeller";
    public static final String FUNC_CREATEPROJECT = "createProject";
    public static final String FUNC_GETSELLERPROJECTS = "getSellerProjects";
    public static final String FUNC_GETPROJECT = "getProject";
    public static final Event PROJECTCREATED_EVENT = new Event("ProjectCreated",
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
            }, new TypeReference<Utf8String>() {
            }, new TypeReference<Utf8String>() {
            }));
    public static final Event PROJECTHASHVALUECHANGED_EVENT = new Event("ProjectHashValueChanged",
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
            }, new TypeReference<Utf8String>() {
            }, new TypeReference<Utf8String>() {
            }));
    ;
    private static final String BINARY = "608060405234801561001057600080fd5b506109e5806100206000396000f30060806040526004361061006c5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663702ef3c881146100715780638d43de2f14610097578063a8f385db146100d8578063c8f107bf1461018a578063f0f3f2c814610208575b600080fd5b34801561007d57600080fd5b506100956004803590602480359081019101356102fe565b005b3480156100a357600080fd5b506100af600435610498565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b3480156100e457600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261009595833573ffffffffffffffffffffffffffffffffffffffff1695369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506104c09650505050505050565b34801561019657600080fd5b506101b873ffffffffffffffffffffffffffffffffffffffff600435166106cb565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156101f45781810151838201526020016101dc565b505050509050019250505060405180910390f35b34801561021457600080fd5b50610220600435610744565b604051808060200180602001838103835285818151815260200191508051906020019080838360005b83811015610261578181015183820152602001610249565b50505050905090810190601f16801561028e5780820380516001836020036101000a031916815260200191505b50838103825284518152845160209182019186019080838360005b838110156102c15781810151838201526020016102a9565b50505050905090810190601f1680156102ee5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b6000606060008581548110151561031157fe5b90600052602060002090600202019150816001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103b95780601f1061038e576101008083540402835291602001916103b9565b820191906000526020600020905b81548152906001019060200180831161039c57829003601f168201915b509394506103d1935050506001840190508585610899565b507f5afc2b55e504768ac1e82623b058f5ea8ffcb67aab49b91b2116a4683faf932385828686604051808581526020018060200180602001838103835286818151815260200191508051906020019080838360005b8381101561043e578181015183820152602001610426565b50505050905090810190601f16801561046b5780820380516001836020036101000a031916815260200191505b50838103825284815260200185858082843760405192018290039850909650505050505050a15050505050565b60016020526000908152604090205473ffffffffffffffffffffffffffffffffffffffff1681565b6104c8610917565b5060408051808201909152828152602080820183905260008054600181810180845583805285518051949586959394929388936002027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563019261052f92849291019061092e565b506020828101518051610548926001850192019061092e565b505050036000818152600160208181526040808420805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff8d169081179091558085526002835281852080549485018155808652838620909401869055815190815260608184018181528c51918301919091528b519698509396507fad3aa9f09c1340721aed53b695898fb8e17c69566ebace264c925a1dcbde0c78958c958c958c9593949093908501926080860192918801918190849084905b8381101561062657818101518382015260200161060e565b50505050905090810190601f1680156106535780820380516001836020036101000a031916815260200191505b50838103825284518152845160209182019186019080838360005b8381101561068657818101518382015260200161066e565b50505050905090810190601f1680156106b35780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a1505050505050565b73ffffffffffffffffffffffffffffffffffffffff811660009081526002602090815260409182902080548351818402810184019094528084526060939283018282801561073857602002820191906000526020600020905b815481526020019060010190808311610724575b50505050509050919050565b6060806000808481548110151561075757fe5b60009182526020918290206002918202018054604080516001831615610100026000190190921693909304601f8101859004850282018501909352828152909350918391908301828280156107ed5780601f106107c2576101008083540402835291602001916107ed565b820191906000526020600020905b8154815290600101906020018083116107d057829003601f168201915b50505050509250806001018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561088c5780601f106108615761010080835404028352916020019161088c565b820191906000526020600020905b81548152906001019060200180831161086f57829003601f168201915b5050505050915050915091565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106108da5782800160ff19823516178555610907565b82800160010185558215610907579182015b828111156109075782358255916020019190600101906108ec565b5061091392915061099c565b5090565b604080518082019091526060808252602082015290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061096f57805160ff1916838001178555610907565b82800160010185558215610907579182015b82811115610907578251825591602001919060010190610981565b6109b691905b8082111561091357600081556001016109a2565b905600a165627a7a72305820916eed98cd428ef7cb9d98f9ba87c23c8766d40e3c8df42cce09751fb4e9d0d30029";
    ;

    protected ProjectBase(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ProjectBase(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RemoteCall<ProjectBase> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProjectBase.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ProjectBase> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ProjectBase.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static ProjectBase load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProjectBase(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ProjectBase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProjectBase(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> changeHashValue(BigInteger _id, String _newHashValue) {
        final Function function = new Function(
                FUNC_CHANGEHASHVALUE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id),
                        new org.web3j.abi.datatypes.Utf8String(_newHashValue)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> projectIdToSeller(BigInteger param0) {
        final Function function = new Function(FUNC_PROJECTIDTOSELLER,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {
                }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createProject(String _address, String _name, String _hashValue) {
        final Function function = new Function(
                FUNC_CREATEPROJECT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address),
                        new org.web3j.abi.datatypes.Utf8String(_name),
                        new org.web3j.abi.datatypes.Utf8String(_hashValue)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<List> getSellerProjects(String _address) {
        final Function function = new Function(FUNC_GETSELLERPROJECTS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {
                }));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<Tuple2<String, String>> getProject(BigInteger _id) {
        final Function function = new Function(FUNC_GETPROJECT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
                }, new TypeReference<Utf8String>() {
                }));
        return new RemoteCall<Tuple2<String, String>>(
                new Callable<Tuple2<String, String>>() {
                    @Override
                    public Tuple2<String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, String>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue());
                    }
                });
    }

    public List<ProjectCreatedEventResponse> getProjectCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROJECTCREATED_EVENT, transactionReceipt);
        ArrayList<ProjectCreatedEventResponse> responses = new ArrayList<ProjectCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProjectCreatedEventResponse typedResponse = new ProjectCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.address_ = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.hashValue = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ProjectCreatedEventResponse> projectCreatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ProjectCreatedEventResponse>() {
            @Override
            public ProjectCreatedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROJECTCREATED_EVENT, log);
                ProjectCreatedEventResponse typedResponse = new ProjectCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.address_ = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.hashValue = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ProjectCreatedEventResponse> projectCreatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROJECTCREATED_EVENT));
        return projectCreatedEventObservable(filter);
    }

    public List<ProjectHashValueChangedEventResponse> getProjectHashValueChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROJECTHASHVALUECHANGED_EVENT, transactionReceipt);
        ArrayList<ProjectHashValueChangedEventResponse> responses = new ArrayList<ProjectHashValueChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProjectHashValueChangedEventResponse typedResponse = new ProjectHashValueChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.oldHashValue = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.newHashValue = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ProjectHashValueChangedEventResponse> projectHashValueChangedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ProjectHashValueChangedEventResponse>() {
            @Override
            public ProjectHashValueChangedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROJECTHASHVALUECHANGED_EVENT, log);
                ProjectHashValueChangedEventResponse typedResponse = new ProjectHashValueChangedEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.oldHashValue = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.newHashValue = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ProjectHashValueChangedEventResponse> projectHashValueChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROJECTHASHVALUECHANGED_EVENT));
        return projectHashValueChangedEventObservable(filter);
    }

    public static class ProjectCreatedEventResponse {
        public Log log;

        public String address_;

        public String name;

        public String hashValue;


    }

    public static class ProjectHashValueChangedEventResponse {
        public Log log;

        public BigInteger id;

        public String oldHashValue;

        public String newHashValue;
    }
}
