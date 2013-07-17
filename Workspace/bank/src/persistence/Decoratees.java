package persistence;


/* Additional import section end */

public interface Decoratees extends  SubjInterface {
    
    public persistence.AbstractPersistentRoot createDecorator() ;

    
}

