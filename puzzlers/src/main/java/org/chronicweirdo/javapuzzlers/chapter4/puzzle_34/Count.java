public class Count {
    public static void main(String[] args) {
        final int START = 2000000000;
        System.out.println(Math.ulp(START));
        int count = 0;
        for (float f = START; f < START + 50; f++)
            count++;
        System.out.println(count);
    }
}
