package seedu.duke.command;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ListPuModulesCommandTest {
    private static final String LINE = "____________________________________________________________";
    //@@author dfa-reused
    //Reused from https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeAll
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public void restoreStream() {
        System.setOut(originalOut);
    }
    //@@ author dfa

    //Solution below adapted from https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    @Test
    void execute_correctLines_success() {
        ListPuModulesCommand listPuModulesCommand = new ListPuModulesCommand(5,"YONSEI UNIVERSITY");
        listPuModulesCommand.execute();
        assertEquals("YONSEI UNIVERSITY Modules" + System.lineSeparator()
                + LINE + System.lineSeparator() + "1. [EEE3314][INTRODUCTION ARTIFICIAL INTELLIGENCE][3]"
                + System.lineSeparator() +
                "   maps to ----> [ME3663][Technical Elective][4]" + System.lineSeparator() +
                "2. [MEU3710][NANO MECHANICAL ENGINEERING][3]" + System.lineSeparator() +
                "   maps to ----> [ME3662][Technical Elective][4]" + System.lineSeparator() +
                "3. [MEU3700][BIOMECHANICS][3]" + System.lineSeparator() +
                "   maps to ----> [ME3661][Technical Elective][4]" + System.lineSeparator() +
                "4. [MEU3600][ADVANCED MECHANICS OF MATERIALS][3]" + System.lineSeparator() +
                "   maps to ----> [ME2114][Mechanics of Materials][4]" + System.lineSeparator() +
                "5. [MEU3680][MECHANICAL SYSTEM CONTROL][3]" + System.lineSeparator() +
                "   maps to ----> [ME2142][Feedback Control Systems][4]" + System.lineSeparator() +
                "6. [MEU3010][Micro Mechanical system][3]" + System.lineSeparator() +
                "   maps to ----> [ME3281][Microsystems Design and Applications][4]" + System.lineSeparator() +
                "7. [MEU5370][Finite Element Method][3]" + System.lineSeparator() +
                "   maps to ----> [ME4291][Finite Element Analysis][4]" + System.lineSeparator() +
                "8. [MEU6230][VISCOUS FLUID DYNAMICS][3]" + System.lineSeparator() +
                "   maps to ----> [ME2135][Intermediate Fluid Mechanics][4]" + System.lineSeparator() +
                "9. [DAA3250][CHEM ENG THERMODYNAMICS I][0]" + System.lineSeparator() +
                "   maps to ----> [ME3221][Sustainable Energy Conversion][4]" + System.lineSeparator() +
                "____________________________________________________________".stripTrailing()
                , outContent.toString().stripTrailing());
        outContent.reset();
    }
}