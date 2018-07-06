//Write your own contracts here. Currently compiles using solc v0.4.15+commit.bbb8e64f.
pragma solidity ^0.4.18;
contract ProjectBase {

  /**Events**/
  event ProjectCreated(address address_,string name, string hashValue);
  event ProjectHashValueChanged(uint id, string oldHashValue, string newHashValue);

  struct Project {
    string name;
    string hashValue;
  }
  Project[] projects;



  mapping (uint => address) public projectIdToSeller; 
  mapping(address=>uint[]) SellerToProjectIds;

  //新建项目
  function createProject(address _address, string _name, string _hashValue) public{
    Project memory project = Project(_name,_hashValue);
    uint id = projects.push(project) - 1;
    projectIdToSeller[id] = _address;
    uint[] storage projectsOfSeller = SellerToProjectIds[_address];
    projectsOfSeller.push(id);

    //emit event
   emit ProjectCreated(_address,_name,_hashValue);
  }


  //更改项目哈希值
  function changeHashValue(uint _id, string _newHashValue) external {
    Project storage project = projects[_id];
    string memory oldHashValue = project.hashValue;
    project.hashValue = _newHashValue;
    emit ProjectHashValueChanged(_id,oldHashValue,_newHashValue);
  }

  //获得一个项目
  function getProject(uint256 _id) external view returns (string name, string hashValue) {
    Project storage project = projects[_id];
    name = project.name;
    hashValue = project.hashValue;
  }

  //通过seller找到它所属的项目
  function getSellerProjects(address _address) external view returns(uint256[] projectsOfSeller) {
     projectsOfSeller =  SellerToProjectIds[_address];

  }
}