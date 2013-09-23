package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface DebitTransferNoValue extends  SubjInterface {
    

    public void accept(DebitTransferNoValueVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitTransferNoValueReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitTransferNoValueExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitTransferNoValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

