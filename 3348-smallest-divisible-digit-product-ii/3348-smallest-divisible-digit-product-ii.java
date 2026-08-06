class Solution {
    private static final Map<Integer, Map<Integer, Integer>> FACTOR_COUNTS = Map.of(
            0, Map.of(),
            1, Map.of(),
            2, Map.of(2, 1),
            3, Map.of(3, 1),
            4, Map.of(2, 2),
            5, Map.of(5, 1),
            6, Map.of(2, 1, 3, 1),
            7, Map.of(7, 1),
            8, Map.of(2, 3),
            9, Map.of(3, 2));

    public String smallestNumber(String num, long t) {
        Pair<Map<Integer, Integer>, Boolean> result = getPrimeCount(t);
        Map<Integer, Integer> needPrime = result.getKey();
        boolean possible = result.getValue();

        if (!possible)
            return "-1";

        Map<Integer, Integer> needDigit = getFactorCount(needPrime);

        if (sumValues(needDigit) > num.length())
            return construct(needDigit);

        Map<Integer, Integer> prefixPrime = getPrimeCount(num);

        int zeroIndex = num.indexOf('0');
        if (zeroIndex == -1) {
            zeroIndex = num.length();
            if (isSubset(needPrime, prefixPrime))
                return num;
        }

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';

            prefixPrime = subtract(prefixPrime, FACTOR_COUNTS.get(digit));

            int remainingSpace = num.length() - 1 - i;

            if (i > zeroIndex)
                continue;

            for (int newDigit = digit + 1; newDigit <= 9; newDigit++) {
                Map<Integer, Integer> needAfterReplace = getFactorCount(
                        subtract(
                                subtract(needPrime, prefixPrime),
                                FACTOR_COUNTS.get(newDigit)));

                if (sumValues(needAfterReplace) <= remainingSpace) {
                    int ones = remainingSpace - sumValues(needAfterReplace);

                    return num.substring(0, i)
                            + newDigit
                            + "1".repeat(ones)
                            + construct(needAfterReplace);
                }
            }
        }

        Map<Integer, Integer> needAfterExtend = getFactorCount(needPrime);

        return "1".repeat(num.length() + 1 - sumValues(needAfterExtend))
                + construct(needAfterExtend);
    }

    // Returns the prime factor count of t and whether it only contains 2,3,5,7.
    private Pair<Map<Integer, Integer>, Boolean> getPrimeCount(long t) {
        Map<Integer, Integer> primeFreq = new HashMap<>();
        primeFreq.put(2, 0);
        primeFreq.put(3, 0);
        primeFreq.put(5, 0);
        primeFreq.put(7, 0);

        int[] primes = {2, 3, 5, 7};

        for (int prime : primes) {
            while (t % prime == 0) {
                t /= prime;
                primeFreq.put(prime, primeFreq.get(prime) + 1);
            }
        }

        return new Pair<>(primeFreq, t == 1);
    }

    // Returns the prime factor count of all digits in num.
    private Map<Integer, Integer> getPrimeCount(String num) {
        Map<Integer, Integer> primeFreq = new HashMap<>();
        primeFreq.put(2, 0);
        primeFreq.put(3, 0);
        primeFreq.put(5, 0);
        primeFreq.put(7, 0);

        for (char ch : num.toCharArray()) {
            Map<Integer, Integer> digitPrime = FACTOR_COUNTS.get(ch - '0');

            for (Map.Entry<Integer, Integer> entry : digitPrime.entrySet()) {
                int prime = entry.getKey();
                int freq = entry.getValue();
                primeFreq.put(prime, primeFreq.get(prime) + freq);
            }
        }

        return primeFreq;
    }

    private Map<Integer, Integer> getFactorCount(Map<Integer, Integer> primeFreq) {
        int count8 = primeFreq.get(2) / 3;
        int rem2 = primeFreq.get(2) % 3;

        int count9 = primeFreq.get(3) / 2;
        int count3 = primeFreq.get(3) % 2;

        int count4 = rem2 / 2;
        int count2 = rem2 % 2;

        int count6 = 0;

        if (count2 == 1 && count3 == 1) {
            count2 = 0;
            count3 = 0;
            count6 = 1;
        }

        if (count3 == 1 && count4 == 1) {
            count2 = 1;
            count6 = 1;
            count3 = 0;
            count4 = 0;
        }

        Map<Integer, Integer> digitFreq = new HashMap<>();
        digitFreq.put(2, count2);
        digitFreq.put(3, count3);
        digitFreq.put(4, count4);
        digitFreq.put(5, primeFreq.get(5));
        digitFreq.put(6, count6);
        digitFreq.put(7, primeFreq.get(7));
        digitFreq.put(8, count8);
        digitFreq.put(9, count9);

        return digitFreq;
    }

    private String construct(Map<Integer, Integer> digitFreq) {
        StringBuilder ans = new StringBuilder();

        for (int digit = 2; digit <= 9; digit++) {
            ans.append(String.valueOf(digit).repeat(digitFreq.get(digit)));
        }

        return ans.toString();
    }

    private boolean isSubset(Map<Integer, Integer> needPrime, Map<Integer, Integer> havePrime) {
        for (Map.Entry<Integer, Integer> entry : needPrime.entrySet()) {
            if (havePrime.get(entry.getKey()) < entry.getValue())
                return false;
        }
        return true;
    }

    private Map<Integer, Integer> subtract(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        Map<Integer, Integer> result = new HashMap<>(first);

        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            int prime = entry.getKey();
            int freq = entry.getValue();

            result.put(prime, Math.max(0, result.get(prime) - freq));
        }

        return result;
    }

    private int sumValues(Map<Integer, Integer> map) {
        int sum = 0;

        for (int value : map.values())
            sum += value;

        return sum;
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}