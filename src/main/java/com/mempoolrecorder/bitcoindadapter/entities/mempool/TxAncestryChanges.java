package com.mempoolrecorder.bitcoindadapter.entities.mempool;

import com.mempoolrecorder.bitcoindadapter.entities.Fees;
import com.mempoolrecorder.bitcoindadapter.entities.TxAncestry;

public class TxAncestryChanges {

	private Fees fees;
	private TxAncestry txAncestry;

	public TxAncestryChanges() {

	}

	public TxAncestryChanges(Fees fees, TxAncestry txAncestry) {
		super();
		this.fees = fees;
		this.txAncestry = txAncestry;
	}

	public Fees getFees() {
		return fees;
	}

	public void setFees(Fees fees) {
		this.fees = fees;
	}

	public TxAncestry getTxAncestry() {
		return txAncestry;
	}

	public void setTxAncestry(TxAncestry txAncestry) {
		this.txAncestry = txAncestry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AncestryChanges [fees=");
		builder.append(fees);
		builder.append(", txAncestry=");
		builder.append(txAncestry);
		builder.append("]");
		return builder.toString();
	}

}
