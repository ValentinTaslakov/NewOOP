package harvestingFields;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        String command = scan.nextLine();

        while (!command.equals("HARVEST")) {

            switch (command) {
                case "private":
					for (Field field : fields) {
						if (Modifier.isPrivate(field.getModifiers())) {
							getPrintf(field);
						}
					}
                    break;
                case "protected":
					for (Field field : fields) {
						if (Modifier.isProtected(field.getModifiers())) {
							getPrintf(field);
						}
					}
                    break;
                case "public":
                    for (Field field : fields) {
                        if (Modifier.isPublic(field.getModifiers())) {
                            getPrintf(field);
                        }
                    }
                    break;
                case "all":
                    for (Field field : fields) {

                        getPrintf(field);
                    }
                    break;
            }

            command = scan.nextLine();
        }
    }

	private static PrintStream getPrintf(Field field) {
		return System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(),
				field.getName());
	}
}
