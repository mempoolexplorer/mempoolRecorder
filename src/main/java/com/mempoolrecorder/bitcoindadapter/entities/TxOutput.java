package com.mempoolrecorder.bitcoindadapter.entities;

public class TxOutput {
	private String address;// Can be null
	private Long amount;// In Satoshis.
	private Integer index;// Begins in 0

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getAddress() {
		return address;
	}

	public Long getAmount() {
		return amount;
	}

	public Integer getIndex() {
		return index;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TxOutput [addressIds=");
		builder.append(address);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", index=");
		builder.append(index);
		builder.append("]");
		return builder.toString();
	}

}
