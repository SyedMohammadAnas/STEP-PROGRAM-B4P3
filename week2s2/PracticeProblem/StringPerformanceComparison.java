public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");
        long startTime = System.nanoTime();
        String result1 = concatenateWithString(1000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(1000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");
        System.out.println("\n=== STRINGBUILDER METHODS ===");
        demonstrateStringBuilderMethods();
        System.out.println("\n=== STRING COMPARISON METHODS ===");
        compareStringComparisonMethods();
        System.out.println("\n=== MEMORY EFFICIENCY ===");
        demonstrateMemoryEfficiency();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) result += "Java " + i + " ";
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < iterations; i++) result.append("Java ").append(i).append(" ");
        return result.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < iterations; i++) result.append("Java ").append(i).append(" ");
        return result.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("Original: " + sb);
        sb.append("!");
        System.out.println("1. After append: " + sb);
        sb.insert(5, " Beautiful ");
        System.out.println("2. After insert: " + sb);
        sb.delete(5, 16);
        System.out.println("3. After delete: " + sb);
        sb.deleteCharAt(5);
        System.out.println("4. After deleteCharAt: " + sb);
        sb.reverse();
        System.out.println("5. After reverse: " + sb);
        sb.reverse();
        sb.replace(6, 11, "Java");
        System.out.println("6. After replace: " + sb);
        sb.setCharAt(0, 'h');
        System.out.println("7. After setCharAt: " + sb);
        System.out.println("8. Capacity: " + sb.capacity());
        sb.ensureCapacity(50);
        System.out.println("9. After ensureCapacity: " + sb.capacity());
        sb.trimToSize();
        System.out.println("10. After trimToSize: " + sb.capacity());
    }

    public static void compareStringComparisonMethods() {
        String str1 = "Hello", str2 = "Hello", str3 = new String("Hello");
        System.out.println("1. == operator (str1 == str2): " + (str1 == str2));
        System.out.println("2. == operator (str1 == str3): " + (str1 == str3));
        System.out.println("3. equals() method: " + str1.equals(str3));
        System.out.println("4. equalsIgnoreCase(): " + str1.equalsIgnoreCase("HELLO"));
        System.out.println("5. compareTo(): " + str1.compareTo("World"));
        System.out.println("6. compareToIgnoreCase(): " + str1.compareToIgnoreCase("HELLO"));
    }

    public static void demonstrateMemoryEfficiency() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memory before operations: " + (runtime.totalMemory() - runtime.freeMemory()) / 1024 + " KB");
        String[] strings = new String[1000];
        for (int i = 0; i < 1000; i++) strings[i] = "String" + i;
        System.out.println("Memory after creating 1000 strings: " + (runtime.totalMemory() - runtime.freeMemory()) / 1024 + " KB");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) sb.append("String").append(i);
        System.out.println("Memory after StringBuilder operations: " + (runtime.totalMemory() - runtime.freeMemory()) / 1024 + " KB");
    }
}
