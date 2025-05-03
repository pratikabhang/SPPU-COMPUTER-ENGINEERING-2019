// SPDX-License-Identifier: Unlicensed
pragma solidity ^0.8.27;

contract MyBank {
    mapping(address => uint) private _balances;
    address public owner;
    event LogDepositMade(address accountHolder, uint amount);
    event LogWithdrawalMade(address accountHolder, uint amount);

    constructor() {
        owner = msg.sender;
        emit LogDepositMade(msg.sender, 1000); // Optional if not meant to be an actual deposit.
    }

    function deposit() public payable returns (uint) {
        require(msg.sender != address(0), "Invalid address");
        require(_balances[msg.sender] + msg.value > _balances[msg.sender], "Deposit overflow error");

        _balances[msg.sender] += msg.value;
        emit LogDepositMade(msg.sender, msg.value);
        return _balances[msg.sender];
    }

    function withdraw(uint withdrawAmount) public returns (uint) {
        require(msg.sender != address(0), "Invalid address");
        require(_balances[msg.sender] >= withdrawAmount, "Insufficient balance");

        _balances[msg.sender] -= withdrawAmount;
        payable(msg.sender).transfer(withdrawAmount);
        emit LogWithdrawalMade(msg.sender, withdrawAmount);
        return _balances[msg.sender];
    }

    function viewBalance() public view returns (uint) {
        return _balances[msg.sender];
    }
}
