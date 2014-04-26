import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class WolvesAndSheep {
	
	public int getmin(String[] field) {

        int R = field.length;

        int best = 100500;

        // Generates all possible horizontal fences sets.
        for (int rsubset = 0; rsubset < (1 << (R - 1)); ++rsubset) {

            // Converts bit mask to horizontal fences set.
            List<Integer> rfences = new ArrayList<Integer>();
            rfences.add(0);

            for(int r = 1; r < R; ++r) {
                if ((rsubset & (1 << (r - 1))) != 0) {
                    rfences.add(r);
                }
            }

            rfences.add(R);

            // Solves 1D problem with given vertical fences set.
            best = min(best, solve1D(field, rfences));
        }

        return best;
	}

    private int solve1D(String[] field, List<Integer> rfences) {
        int rpieces = rfences.size() - 1;
        int C = field[0].length();

        int cl = 0, cpieces = 0;

        // Fixates left vertical fence range.
        while (cl < C) {
            int cr = cl;

            // Count of sheeps and wolfs inside the given range between vertical fences.
            int[] scount = new int[rpieces];
            int[] wcount = new int[rpieces];

            // Moves the right vertical fence range while inside is only one type of animals
            while (cr < C) {
                boolean ok = true;

                // Checks each vertical piece between given horizontal range.
                for (int i = 0; i < rpieces; ++i) {
                    int s = 0;
                    int w = 0;

                    // Counts sheeps and wolfs inside each rectangle.
                    for (int j = rfences.get(i); j < rfences.get(i + 1); ++j) {
                        if (field[j].charAt(cr) == 'S')
                            s++;
                        if (field[j].charAt(cr) == 'W')
                            w++;

                        scount[i] += s;
                        wcount[i] += w;
                    }

                    // If on this step we met sheeps and wolfs inside the same horizontal piece, that means we went to far.
                    if (scount[i] != 0 && wcount[i] != 0)
                        ok = false;
                }

                // If ok, move the right fence further.
                if (ok)
                    ++cr;
                else
                   break;
            }

            // This horizontal fence set is invalid. We can't split sheeps from wolfs.
            if (cl == cr)
                return 100500;

            // Go to the next vertical piece.
            cl = cr;
            ++cpieces;
        }

        // The result is a sum of rpieces - 1 and cpieces - 1;
        return cpieces + rpieces - 2;
    }
}
