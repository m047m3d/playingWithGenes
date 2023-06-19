import java.util.Scanner;

public class Gene {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
	    // String dna = reader.next();

	    // String dna = "AATGCGTAATTAATCG";
	    // String dna = "ATGATCGCTGATTAGGCTTAAATGACG";
	    String dna = "CCATGCGCTTAATGATAGATTAA";
	    
	    //String stopCodon = reader.next(); // could be: TTA, TGA or TAG
	    String stopCodon = "TAA";
		
		System.out.println("hello gene: " + findG(dna, stopCodon));
	}
	
	public static String findG(String dna, String stopCodon) {
	    boolean found = false; // Gene not found
	    int startG = dna.indexOf("ATG");
	    int endG = dna.indexOf(stopCodon, startG+3);
	    String gene = dna.substring(startG, endG + 3);
	    
	    if (startG < 0 || endG < 0) return "gene doesn't exist in this DNA...";
	    
	    while (!found) {
	        if ((endG-startG) % 3 == 0) {
	            found = true;
	            return dna.substring(startG, endG+3);
	        }
	        endG = dna.indexOf(stopCodon, endG+1);
	    }
	    return "not a valid gene";
	}
}

