package org.example;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName mbeanName = new ObjectName("com.example:type=LoggingControlMBean");
        LoggingControlMBean mbean = new LoggingControl();
        mbs.registerMBean(mbean, mbeanName);

        System.out.println("Hello! Please type somrthing");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String transformedString = transformString(line);
        System.out.println(transformedString);
    }

    public static String transformString(String input) {
        char[] chars = input.toCharArray();
        char[] transformedChars = new char[chars.length];
        int transformedCharsCount = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                if (i % 2 == 0) {
                    transformedChars[transformedCharsCount] = Character.toLowerCase(c);
                } else {
                    transformedChars[transformedCharsCount] = Character.toUpperCase(c);
                }
                transformedCharsCount++;
            }
        }

        char[] finalTransformedChars = new char[transformedCharsCount];
        System.arraycopy(transformedChars, 0, finalTransformedChars, 0, transformedCharsCount);
        return new String(finalTransformedChars);
    }
}