// Determine if Mp = 2^p − 1 is prime for p > 2
// Lucas–Lehmer(p)
//    var s = 4
//    var M = 2^p − 1
//    repeat p − 2 times:
//        s = ((s × s) − 2) mod M
//    if s == 0 return PRIME else return COMPOSITE

import java.math.BigInteger;

public class PrimalityTest{
    public static void main (String[] args){
        long startTime = System.currentTimeMillis();
        int mersenneExp = 110503;
        System.out.print("2^" + mersenneExp + " - 1 is a prime: ");
        if (mersenneExp != 2 && mersenneExp % 2 != 0 && testPrimeDivisors(mersenneExp)){
            System.out.println(testPrimeLucasLehmer(mersenneExp));
        }
        else if (mersenneExp == 2) System.out.println("true");
        else System.out.println("false");
        long endTime = System.currentTimeMillis();
        System.out.println("Computation time: " + (endTime - startTime) + " ms");
    }
    static boolean testPrimeLucasLehmer(int p){
        BigInteger s = BigInteger.valueOf(4);
        BigInteger m = BigInteger.valueOf(2).pow(p).subtract(BigInteger.ONE);
        for (int i = 0; i < p - 2; ++i){
            s = (((s.multiply(s).subtract(BigInteger.valueOf(2))).mod(BigInteger.valueOf(2).pow(p))).add(s.multiply(s).subtract(BigInteger.valueOf(2)).divide(BigInteger.valueOf(2).pow(p)))).mod(m); 
        }
        if (s == BigInteger.ZERO) return true;
        else return false;
    }
    static boolean testPrimeDivisors(int val){
        for (int i = 2; i <= Math.floor(Math.sqrt(val)); ++i){
            if (val % i == 0) return false;
        }
        return true;
    }
}

// time to check (initial algorithm)
// p = 86243        ~ 12 minutes on desktop
