package bank;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Statement {

    private static final int TOP_OF_THE_LIST = 0;
    private static final String STATEMENT_HEADER = "   Date    ||  Balance ||  Type ";

    private List<StatementLine> statementLines = new LinkedList<StatementLine>(); //Lista de transacciones

    //Agrega linea al inicio de la lista
    public void addLineContaining(Transaction transaction, Amount currentBalance){
        statementLines.add(TOP_OF_THE_LIST,new StatementLine(transaction,currentBalance));
    }

    //imprime el header y la lista despues
    public void printTo(PrintStream printer){
        printer.println(STATEMENT_HEADER);
        printStatementLine(printer);
    }

    //Imprime las lineas de la lista una a una
    private void printStatementLine(PrintStream printer){
        for (StatementLine statementLine: statementLines){
            statementLine.printTo(printer);
        }
    }
}
