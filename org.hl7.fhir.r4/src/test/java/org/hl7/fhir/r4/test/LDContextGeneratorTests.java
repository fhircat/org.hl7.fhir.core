package org.hl7.fhir.r4.test;

import org.fhir.ucum.UcumException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.LDContextGenerator;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LDContextGeneratorTests {

//  String basePath = FileSystems.getDefault().getPath(System.getProperty("java.io.tmpdir")).toString() + "/";
//  String basePath = "E:/workspace/temp/R4/";

  String outputDir = System.getProperty("user.home") + java.io.File.separator + "LDContexts" + java.io.File.separator + "R4" + java.io.File.separator;

  private void mkdirs() {
    File temp = new File(outputDir);
    if(temp.exists() == false) {
      temp.mkdirs();
    }
  }

  private void doTest(String name) throws IOException, FHIRException {
    StructureDefinition sd = TestingUtilities.context().
      fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(name, null));

    if(sd == null) {
      throw new FHIRException("StructuredDefinition for " + name + " was null");
    }
    //String outPath = basePath + name.toLowerCase() + ".context.jsonld";

    LDContextGenerator ldContextGenerator = new LDContextGenerator();


    ConcurrentHashMap<String, String> renderedJson = ldContextGenerator.generate(sd);

    // write each json string to a file
    // may be multiples if there were BackboneElements processed.
    for (String jsonName : renderedJson.keySet()){
      TextFile.stringToFile(renderedJson.get(jsonName), outputDir + jsonName.replace(':', '-').toLowerCase() + ".context.jsonld", false);
    }

   //TextFile.stringToFile(ldContextGenerator.generate(sd), outPath);
  }

  /**
   * Go through all StructureDefinitions and generate context jsonld.
   * @throws IOException
   * @throws FHIRException
   */
  private void doTestAll() throws IOException, FHIRException {
    System.out.println("Generating LD Contexts");
    List<StructureDefinition> sds = TestingUtilities.context().allStructures();
    ConcurrentHashMap<String, String> renderedJson;

    for(StructureDefinition sd : sds) {
      if (sd == null ) {
        throw new FHIRException("StructuredDefinition was null");
      }

      synchronized(this) {
        LDContextGenerator ldContextGenerator = new LDContextGenerator();

        renderedJson = ldContextGenerator.generate(sd);

        // write each json string to a file
        // may be multiples if there were BackboneElements processed.
        for (String jsonName : renderedJson.keySet()) {
          TextFile.stringToFile(renderedJson.get(jsonName), outputDir + jsonName.replace(':', '-').toLowerCase() + ".context.jsonld", false);
        }

      }
    }
  }

  @Test
  public void testAll() throws FHIRException, IOException, UcumException {
    this.mkdirs();
    System.out.println("Writing contexts to: " + outputDir);
    doTestAll();
  }

//  @Test
//  public void testDoseage() throws FHIRException, IOException, UcumException {
//    doTest("Dosage");
//  }

//  @Test
//  public void testUnsignedInt() throws FHIRException, IOException, UcumException {
//    doTest("positiveInt");
//  }

//  @Test
//  public void testMedicationUsage() throws FHIRException, IOException, UcumException {
//    doTest("MedicationUsage");
//  }

//    @Test
//  public void testBundle() throws FHIRException, IOException, UcumException {
//    doTest("Bundle");
//  }
//
//  @Test
//  public void testIdentifier() throws FHIRException, IOException, UcumException {
//    doTest("Identifier");
//  }

//  @Test
//  public void testExpression() throws FHIRException, IOException, UcumException {
//    doTest("Expression");
//  }

//  @Test
//  public void testDevice() throws FHIRException, IOException, UcumException {
//    doTest("Device");
//  }

//  @Test
//  public void testDosage() throws FHIRException, IOException, UcumException {
//    doTest("Dosage"); // No backbone element, but has element that needs to be its own context file
//  }

//  @Test
//  public void testObservationDefinition() throws FHIRException, IOException, UcumException {
//    doTest("ObservationDefinition");  // *** doesn't have backbone element, but is on fhir website... referenceRange type (need to check) ***
//  }

//  @Test
//  public void testElementDefinition() throws FHIRException, IOException, UcumException {
//    doTest("ElementDefinition");  // *** doesn't have backbone element, but is on fhir website... referenceRange type (need to check) ***
//  }

//  @Test
//  public void testObservation() throws FHIRException, IOException, UcumException {
//    doTest("Observation");  // *** doesn't have backbone element, but is on fhir website... referenceRange type (need to check) ***
//  }

//  @Test
//  public void testDataRequirement() throws FHIRException, IOException, UcumException {
//    doTest("DataRequirement");  // *** doesn't have backbone element ***
//  }

//  @Test
//  public void testAuditEvent() throws FHIRException, IOException, UcumException {
//    doTest("AuditEvent");
//  }

//  @Test
//  public void testAllergyIntolerance() throws FHIRException, IOException, UcumException {
//    doTest("AllergyIntolerance");
//  }
//
//  @Test
//  public void testAccount() throws FHIRException, IOException, UcumException {
//    doTest("Account");
//  }
//
//  @Test
//  public void testPatient() throws FHIRException, IOException, UcumException {
//    doTest("Patient");
//  }
//
//  @Test
//  public void testActivityDefinition() throws FHIRException, IOException, UcumException {
//    doTest("ActivityDefinition");
//  }
//
//  @Test
//  public void testMedicationRequest() throws FHIRException, IOException, UcumException {
//    doTest("MedicationRequest");
//  }
//
//  @Test
//  public void testTiming() throws FHIRException, IOException, UcumException {
//    doTest("Timing");
//  }

//  @Test
//  public void testDateTime() throws FHIRException, IOException, UcumException {
//    doTest("dateTime");
//  }
//
//  @Test
//  public void testAddress() throws FHIRException, IOException, UcumException {
//    doTest("Address");
//  }
//  @Test
//  public void testReference() throws FHIRException, IOException, UcumException {
//    doTest("Reference");
//  }
//    @Test
//    public void testString() throws FHIRException, IOException, UcumException {
//      doTest("string");
//  }

//  @Test
//    public void testAdverseEvent() throws FHIRException, IOException, UcumException {
//      doTest("AdverseEvent");
//  }


}
