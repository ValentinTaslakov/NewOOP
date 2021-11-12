package RhombusOfStars;

public class Rhombus {
    private final int size;


    public Rhombus(int n) {
        this.size = n;
    }

    public String getRhombus() {

        String rhombus = getUpperSide(size) + getDownSide(size);

        return rhombus;
    }

    private static String getUpperSide(int n) {
        String upSide = "";
        for (int row = n - (n - 1); row <= n - 1; row++) {

            for (int repeat = 0; repeat < n-row; repeat++) {
                upSide += " ";
            }

            for (int j = 0; j < row; j++) {

                upSide += "* ";
            }

            upSide += System.lineSeparator() ;
        }

        return upSide;

    }

    private static String getDownSide(int n) {

        String downSide = "";

        for (int row = n; row >= n - (n - 1); row--) {

            for (int i = 0; i < n-row; i++) {
                downSide += " ";
            }

            for (int j = 1; j <= row; j++) {

                downSide += "* ";
            }

            downSide += System.lineSeparator() ;

        }

        return downSide.trim();
    }
}
