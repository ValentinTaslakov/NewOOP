package TrafficLights;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Lights> signals = Arrays.stream(scan.nextLine().trim().split("\\s+"))
                .map(Lights::valueOf)
                .collect(Collectors.toList());
        System.out.println();

    }
}
