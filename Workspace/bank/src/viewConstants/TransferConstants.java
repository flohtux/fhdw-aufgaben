package viewConstants;


public class TransferConstants {

	public final static String BalanceRegex = "@zero@=0;" + "@nonZeroNum@=[9|8|7|6|5|4|3|2|1];" + "@num@=[@zero@ | @nonZeroNum@];" + "@int@=([(@nonZeroNum@@num@*) | @zero@]);" + "@point@=,;" +
			"@oneToThree@=(@nonZeroNum@@num@?@num@?);" + "@three@=(@num@@num@@num@);" + "@intDotted@=([(@oneToThree@ (.@three@)*) | @zero@]);" +
			"([@int@ | @intDotted@] (@point@ @num@@num@?)?)";
	
	
}
