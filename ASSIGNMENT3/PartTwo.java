package ASSIGNMENT3;

// imports

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartTwo {
    
    private BufferedReader fileReader;
    private String currToken;

    // main (test using args[] ***DELETE OR COMMENT OUT AFTER***)
    public static void main(String[] args) {

        PartTwo parser = new PartTwo();

        try {
            parser.openFile(args[0]);
            parser.move(); 
            parser.program();
 
            System.out.println("SUCCESS"); // hooray
        } catch (ParseException e) {
            System.out.println("ERROR");
        } catch (IOException e) {
            System.out.println("ERROR");
        } finally {
            parser.closeFile();
        }
    }

    // file handling

    private void openFile(String filename) throws IOException {
        fileReader = new BufferedReader(new FileReader(filename));
    }
 
    private void closeFile() {
        if (fileReader != null) {
            try { fileReader.close(); } catch (IOException e) {}
        }
    }

    private void move() throws IOException {
        String str;

        while ((str = fileReader.readLine()) != null) {
            str = str.trim();

            if (!str.isEmpty()) {
                currToken = str;
                return;
            }
        }

        currToken = null;
    }

    private void match(String expect) throws IOException, ParseException {
        if (currToken == null || !currToken.equals(expect)) {
            throw new ParseException("Syntax Error");
        }

        move();
    }

    // non terminal parse functions

    private void program() throws IOException, ParseException {
        match("{");
        statementList();
        match("}");
        match("$");

        if (currToken != null) 
            throw new ParseException("Unexpected token after end of program");
    }

    private void statementList() throws IOException, ParseException {
        statement();
        match(";");
        statementListTail();
    }

    private void statementListTail() throws IOException, ParseException {
        if ("call".equals(currToken) || "compute".equals(currToken)) {
            statement();
            match(";");
            statementListTail();
        }
    }

    private void statement() throws IOException, ParseException {
        if ("call".equals(currToken)) {
            match("call");
            match(":");
            procedureCall();

        } else if ("compute".equals(currToken)) {
            match("compute");
            match(":");
            expression();
    
        } else 
            throw new ParseException("Unexpected token in place of 'call' or 'compute'");
    }

    private void procedureCall() throws IOException, ParseException {
        match("id");
        match("(");
        parameters();
        match(")");
    }

    private void parameters() throws IOException, ParseException {
        factor();
        parametersTail();
    }

    private void parametersTail() throws IOException, ParseException {
        if (",".equals(currToken)) {
            match(",");
            factor();
            parametersTail();
        }
    }

    private void expression() throws IOException, ParseException {
        match("id");
        match("=");
        factor();
        expressionTail();
    }

    private void expressionTail() throws IOException, ParseException {
        if ("+".equals(currToken)) {
            match("+");
            factor();
        } else if ("-".equals(currToken)) {
            match("-");
            factor();
        }
    }

    private void factor() throws IOException, ParseException {
        if ("id".equals(currToken)) 
            match("id");

        else if ("num".equals(currToken))
            match("num");
        
        else
            throw new ParseException("Unexpected token found in place of 'id' or 'num");
    }

    // custom exception

    private static class ParseException extends Exception {

        ParseException(String message) {
            super(message);
        }
    }
}
