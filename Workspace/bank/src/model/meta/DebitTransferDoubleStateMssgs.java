package model.meta;

public interface DebitTransferDoubleStateMssgs {
    void accept(DebitTransferDoubleStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferDoubleStateDOWNMssgs extends Mssgs, DebitTransferDoubleStateMssgs{}
interface DebitTransferDoubleStateUPMssgs extends Mssgs, DebitTransferDoubleStateMssgs{}
