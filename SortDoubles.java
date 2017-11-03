import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Period12 on 11/2/17.
 */
public class SortDoubles {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter three numbers separated by spaces.");
        String answer = keyboard.nextLine();
        Scanner parser = new Scanner(answer);
        ArrayList<Double> store = new ArrayList<>();
        while (parser.hasNextDouble()){
            store.add(parser.nextDouble());
        }
        Double[] nums = store.toArray(new Double[store.size()]);
        nums[0] = findMin(-Double.MAX_VALUE, store);
        for (int i = 1; i < nums.length; ++i){
            nums[i] = findMin(nums[i - 1], store);
        }
        System.out.println("Sorted inputs: " + Arrays.toString(nums));
    }

    private static Double findMin(double lowerBound, ArrayList<Double> args) {
        Double min = Double.MAX_VALUE;
        for (Double arg : args) {
            if (arg < min && arg > lowerBound) {
                min = arg;
            }
        }
        return min;
    }
}
/*
"C:\Program Files\Java\jdk-9\bin\java" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2017.2.5\lib\idea_rt.jar=56154:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2017.2.5\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\mdot\Downloads\SortDoubleProgram-20171103T033815Z-001\SortDoubleProgram\out\production\SortDoubleProgram SortDoubles
Please enter three numbers separated by spaces.
39.96394084985 -56.261039806397 -38.08205104439 91.956678693417 -24.427769975983 -91.647544499245 51.101612490905 -1.0741287824866 -71.349011051656 37.426743088665 54.32664235157 -26.192740748437 29.295286403954 49.040849583332 -86.341445211381 58.061016305518 -34.908184665863 82.210726007274 71.020089850497 -36.092978905585
Sorted inputs: [-91.647544499245, -86.341445211381, -71.349011051656, -56.261039806397, -38.08205104439, -36.092978905585, -34.908184665863, -26.192740748437, -24.427769975983, -1.0741287824866, 29.295286403954, 37.426743088665, 39.96394084985, 49.040849583332, 51.101612490905, 54.32664235157, 58.061016305518, 71.020089850497, 82.210726007274, 91.956678693417]

Process finished with exit code 0
*/