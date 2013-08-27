package view.objects;


/* Additional import section end */

public class DebitTransfersDebitTransferListeWrapper extends AssociationInTreeWrapper {

	public DebitTransfersDebitTransferListeWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	    public void setIcon(IconRenderer renderer) {
    	this.getWrappedObject().setIcon(renderer);
    }
	
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association debitTransfers in class DebitTransferListe
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
