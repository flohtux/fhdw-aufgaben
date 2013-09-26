package model.meta;

public interface DebitTransferPayedFeesMssgs {
    void accept(DebitTransferPayedFeesMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferPayedFeesDOWNMssgs extends Mssgs, DebitTransferPayedFeesMssgs{}
interface DebitTransferPayedFeesUPMssgs extends NoPayedFeesUPMssgs, DebitTransferPayedFeesMssgs{}
