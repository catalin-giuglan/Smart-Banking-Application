package org.poo.cb;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEBankingApp {

    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String REFERENCE_FILE = "output.txt";
    private static final String STOCK_VALUES_CSV = "stockValues.csv";
    private static final String EXCHANGE_RATE = "exchangeRates.csv";
    private static final String COMMANDS = "commands.txt";


    @Test
    public void testTheTest() {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));

        Main.main(null);

        assert (outPrintStream.toString().trim()).equals("Running Main");
        System.setOut(System.out);
    }

    @Test
    public void test1() throws IOException {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));
        String commandFolder = "test1/";

        Main.main(getInputArgs(commandFolder));
        String output = outPrintStream.toString();

        assertJsonLineAreEqual(output, commandFolder);

        System.setOut(System.out);
    }

    @Test
    public void test2() throws IOException {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));
        String commandFolder = "test2/";

        Main.main(getInputArgs(commandFolder));
        String output = outPrintStream.toString();

        assertJsonLineAreEqual(output, commandFolder);

        System.setOut(System.out);
    }

    @Test
    public void test3() throws IOException {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));
        String commandFolder = "test3/";

        Main.main(getInputArgs(commandFolder));
        String output = outPrintStream.toString();

        assertJsonLineAreEqual(output, commandFolder);

        System.setOut(System.out);
    }

    @Test
    public void test4() throws IOException {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));
        String commandFolder = "test4/";

        Main.main(getInputArgs(commandFolder));
        String output = outPrintStream.toString();

        assertJsonLineAreEqual(output, commandFolder);

        System.setOut(System.out);
    }

    @Test
    public void test5() throws IOException {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));
        String commandFolder = "test5/";

        Main.main(getInputArgs(commandFolder));
        String output = outPrintStream.toString();

        assertJsonLineAreEqual(output, commandFolder);

        System.setOut(System.out);
    }

    @Test
    public void test6() throws IOException {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));
        String commandFolder = "test6/";

        Main.main(getInputArgs(commandFolder));
        String output = outPrintStream.toString();

        assertJsonLineAreEqual(output, commandFolder);

        System.setOut(System.out);
    }

    @Test
    public void test7() throws IOException {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));
        String commandFolder = "test7/";

        Main.main(getInputArgs(commandFolder));
        String output = outPrintStream.toString();

        assertJsonLineAreEqual(output, commandFolder);

        System.setOut(System.out);
    }

    @Test
    public void test8() throws IOException {
        ByteArrayOutputStream outPrintStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPrintStream));
        String commandFolder = "test8/";

        Main.main(getInputArgs(commandFolder));
        String output = outPrintStream.toString();

        assertJsonLineAreEqual(output, commandFolder);

        System.setOut(System.out);
    }

    private void assertJsonLineAreEqual(String actualOutput, String inputFolder)
            throws IOException {

        BufferedReader
                expectedOutput =
                new BufferedReader(new FileReader(
                        Thread.currentThread().getContextClassLoader().getResource(inputFolder
                                + REFERENCE_FILE).getFile()));
        BufferedReader actualOutputFile = new BufferedReader(new StringReader(actualOutput));
        String expectedJsonLine;
        String actualJsonLine;
        while ((expectedJsonLine = expectedOutput.readLine()) != null) {
            actualJsonLine = actualOutputFile.readLine();
            if (actualJsonLine == null) {
                Assertions.fail();
            }

            if(!isValid(actualJsonLine)){
                assertEquals(expectedJsonLine.toLowerCase(), actualJsonLine.toLowerCase());
                return;
            }

            JsonNode jsonNodeActual = objectMapper.readTree(actualJsonLine.toLowerCase());
            JsonNode jsonNodeExpected = objectMapper.readTree(expectedJsonLine.toLowerCase());
            assertEquals(toSet(jsonNodeExpected), toSet(jsonNodeActual));

        }
    }

    private String[] getInputArgs(String inputFolder) {
        return new String[]{"common/" + EXCHANGE_RATE,
                inputFolder + STOCK_VALUES_CSV,
                inputFolder + COMMANDS};
    }

    public boolean isValid(String json) {
        try {
            objectMapper.readTree(json);
        } catch (JacksonException e) {
            return false;
        }
        return true;
    }

    public Set<JsonNode> toSet(JsonNode jsonNode) {
        Set<JsonNode> set = new HashSet<>();
        if(jsonNode.get("stockstobuy") != null) {
            JsonNode stocksToBuyList = jsonNode.get("stockstobuy");
            if (stocksToBuyList.isArray()) {
                for (JsonNode node : stocksToBuyList) {
                    set.add(node);
                }
            }
        } else {
            set.add(jsonNode);
        }
        return set;
    }
}
