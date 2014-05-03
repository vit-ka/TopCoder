public class PeopleCircle {

    public String order(int numMales, int numFemales, int K) {
        char[] people = new char[numMales + numFemales];

        for (int i = 0; i < people.length; ++i)
            people[i] = 'M';

        int currentIndex = 0;
        int currentShift = 1;
        for (int i = 0; i < numFemales; ++i) {
            while (currentShift < K || (currentShift == K && people[currentIndex] == 'F')) {
                if (people[currentIndex] == 'M') {
                    currentShift++;
                }

                currentIndex = (currentIndex + 1) % people.length;
            }

            people[currentIndex] = 'F';
            currentShift = 1;
            currentIndex = (currentIndex + 1) % people.length;
        }

        return new String(people);
    }
}
