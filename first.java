//import org.apache.commons.cli.CommandLine;
//import org.apache.jena.riot.RDFFormat;

import nl.wur.ssb.RDFSimpleCon.RDFSimpleCon;
import nl.wur.ssb.RDFSimpleCon.data.Domain;
import nl.wur.ssb.RDFSimpleCon.data.Property;
import nl.wur.ssb.RDFSimpleCon.data.RDFSubject;
import nl.wur.ssb.RDFSimpleCon.data.RDFType;

public class first {
	private static RDFSimpleCon sappRDFSource;
	private static Domain domain;
	//private static RDFSubject genome;
	//private static CommandLine arguments;
	//private static int codon;

	public static void main(String[] args) throws Exception {
		// Creation of a new database
		sappRDFSource = new RDFSimpleCon("");
		domain = new Domain(sappRDFSource);
		// Setting the shortcuts
		setPrefixes();
		setClasses();
		setPredicates();
		
		// Add the root (genome)
		RDFSubject Genome = new RDFSubject(domain, "ssb:" + "myAwesomeGenome", "ssb:Genome");
		RDFSubject DnaObject = new RDFSubject(domain, "ssb:" + "myAwesomeGenome/DnaObject1", "ssb:DnaObject");
		Genome.add("ssb:identifier", 1543465);
		Genome.add("ssb:dnaobject", DnaObject);
		DnaObject.add("ssb:identifier", 654987);
		sappRDFSource.save("test.ttl");
		
	}

	private static void setPredicates() {
		new Property(domain, "ssb:identifier");
		new Property(domain, "ssb:dnaobject");
	}

	private static void setClasses() {
		RDFType Genome = new RDFType(domain, "ssb:Genome");
		new RDFType(domain, "ssb:DnaObject");
	}

	private static void setPrefixes() {
		sappRDFSource.setNsPrefix("ssb", "http://csb.wur.nl/genome/");
		sappRDFSource.setNsPrefix("protein", "http://csb.wur.nl/genome/protein/");

	}
}