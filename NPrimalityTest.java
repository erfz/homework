// Determine if Mp = 2^p − 1 is prime for p > 2
// Lucas–Lehmer(p)
//    var s = 4
//    var M = 2^p − 1
//    repeat p − 2 times:
//        s = ((s × s) − 2) mod M
//    if s == 0 return PRIME else return COMPOSITE

import java.math.BigInteger;
import java.io.*;

public class NPrimalityTest{
    public static void main (String[] args){
        String fileName = "MersennePrimeCheck.txt";
        int mersenneExp = 1;
        int finalMersenneIndex = 10000;
        int primeCount = 0;
        long startTime = System.currentTimeMillis();
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Checking primality of Mersenne numbers of the form 2^p - 1: p = " + mersenneExp + " to " + finalMersenneIndex);
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            while (mersenneExp <= finalMersenneIndex){
                String writeDisplayString = "    ";
                for (int i = 0; i < Integer.toString(finalMersenneIndex).length() - Integer.toString(mersenneExp).length(); ++i) writeDisplayString = writeDisplayString.concat(" ");
                if (mersenneExp != 2 && testPrimeDivisors(mersenneExp) && testPrimeLucasLehmer(mersenneExp)){
                    ++primeCount;
                    bufferedWriter.write(mersenneExp + writeDisplayString + "true");
                    bufferedWriter.newLine();
                }
                else if (mersenneExp == 2){
                    bufferedWriter.write(mersenneExp + writeDisplayString + "true");
                    bufferedWriter.newLine();
                }
//              else bufferedWriter.write("false");
                ++mersenneExp;
            }
            bufferedWriter.newLine();
            long endTime = System.currentTimeMillis();
            bufferedWriter.write("Number of primes found: " + primeCount);
            bufferedWriter.newLine();
            bufferedWriter.write("Computation time: " + (endTime - startTime) + " ms");            
            bufferedWriter.close();
        }
        catch(IOException ex){
            System.out.println("Error writing to file " + fileName);
        }
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
// ~21 minutes; first 10000
