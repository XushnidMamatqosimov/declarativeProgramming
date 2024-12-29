package uz.pdp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        int n = 100;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
            if (i % 2 == 0) {
                System.out.println(i + " bu son 2 ga qoldiqsiz bolinadi;");
                count++;
            }
        }
        System.out.println(n + " n gacha bolgan raqamlar ichida 2 ga bolinadiganlari soni: " + count);
    }
}