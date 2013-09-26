package model.meta;

public interface NoPayedFeesMssgs {
    void accept(NoPayedFeesMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoPayedFeesDOWNMssgs extends DebitTransferPayedFeesDOWNMssgs, NoPayedFeesMssgs{}
interface NoPayedFeesUPMssgs extends Mssgs, NoPayedFeesMssgs{}
