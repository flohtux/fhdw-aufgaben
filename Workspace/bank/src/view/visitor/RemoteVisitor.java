
package view.visitor;

import view.*;

public interface RemoteVisitor extends ServiceVisitor{
    
    public void handleServer(ServerView server) throws ModelException;
    
}
