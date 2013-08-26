package common;

import expressions.RegularExpressionHandler;

public class RegularExpressionManager {

    public static RegularExpressionHandler debitTransferTransactionSUBTYPEName = new RegularExpressionHandler( "[(Transaction)" + 
		"(Transfer)" + 
		"(Debit)]" );
    public static RegularExpressionHandler currencySUBTYPEName = new RegularExpressionHandler( "[(Dollar)" + 
		"(Pfund)" + 
		"(Franken)" + 
		"(Euro)" + 
		"(Yen)]" );
    public static RegularExpressionHandler transactionFeeSUBTYPEName = new RegularExpressionHandler( "[(MixedFee)" + 
		"(FixTransactionFee)" + 
		"(ProcentualFee)]" );
    public static RegularExpressionHandler limitTypeSUBTYPEName = new RegularExpressionHandler( "[(NoLimit)" + 
		"(Limit)]" );
    

}
