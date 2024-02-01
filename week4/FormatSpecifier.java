import javax.xml.crypto.Data;

public class FormatSpecifier {
    public static void main(String[] args) {
        int integerValue = 123;
        double floatingPointValue = 12345.6789;
        String stringValue = "Hello, World!"
        Integer k = 3456;
        Date datevalue = new Date();

        System.out.printf("Integer (Decimal): %d%n", integerValue);
        System.out.printf("Integer (Hexadecimal): %x%n", integerValue);
        System.out.printf("Integer (Octal): %o%n", integerValue);

        System.out.printf("Floating-point (General): %o%n", integerValue);
    }
}
