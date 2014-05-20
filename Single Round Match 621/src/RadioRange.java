import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RadioRange {
	
	public double RadiusProbability(int[] X, int[] Y, int[] R, int Z) {

        List<Double> radiusToCheck = new ArrayList<Double>();
        radiusToCheck.add(0.0);
        radiusToCheck.add(Z * 1.0);

        for (int i = 0; i < X.length; ++i) {
            double x = X[i];
            double y = Y[i];
            double d1 = Math.sqrt(x * x + y * y) - R[i];
            double d2 = Math.sqrt(x * x + y * y) + R[i];

            if (d1 <= Z && !radiusToCheck.contains(d1))
                radiusToCheck.add(d1);

            if (d2 <= Z && !radiusToCheck.contains(d2))
                radiusToCheck.add(d2);
        }

        Collections.sort(radiusToCheck);
        List<PairR> goods = new ArrayList<PairR>();

        for (int i = 0; i < radiusToCheck.size() - 1; ++i) {
            double r1 = radiusToCheck.get(i);
            double r2 = radiusToCheck.get(i+1);

            PairR pairR = new PairR();
            pairR.r1 = r1;
            pairR.r2 = r2;

            if (isGood(pairR, X, Y, R)) {
                goods.add(pairR);
            }
        }

        double goodSum = 0;
        for (PairR pair : goods) {
            goodSum += pair.r2 - pair.r1;
        }

        return goodSum / Z;
	}

    private boolean isGood(PairR pairR, int[] X, int[] Y, int[] r) {
        double rToCheck = (pairR.r2 + pairR.r1) / 2.0;
        for (int i = 0; i < X.length; ++i) {
            double x = X[i];
            double y = Y[i];
            double a =  Math.sqrt(x * x + y * y);

            if (rToCheck > a - r[i] && rToCheck < a + r[i])
                return false;
        }

       return true;
    }

    public class PairR {
        public double r1;
        public double r2;
    }
}
