package com.example.casestudy.dto.contract;

public class ContractDetailDto {
    private int id;

    private int quantity;

    private ContractDto contractId;

    private AttachFacilityDto attachFacilityId;

    public ContractDetailDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ContractDto getContractId() {
        return contractId;
    }

    public void setContractId(ContractDto contractId) {
        this.contractId = contractId;
    }

    public AttachFacilityDto getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(AttachFacilityDto attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }
}
