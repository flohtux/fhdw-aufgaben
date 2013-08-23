
package model.visitor;

import persistence.*;

public interface AccountServiceCommandReturnVisitor<R> {
    
    public R handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException;
    public R handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException;
    public R handleExecuteTransferCommand(PersistentExecuteTransferCommand executeTransferCommand) throws PersistenceException;
    
}
