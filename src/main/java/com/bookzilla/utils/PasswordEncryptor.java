package com.bookzilla.utils;

import java.util.Random;

/**
 * Created by adinu on 12/4/16.
 */
public class PasswordEncryptor {

    private static long public_key;

    private static long private_key;

    private static long for_modulo;

    static long powmod(long nr, long k, long m){
        if (k == 0)
            return 1;
        return ( ((k % 2 == 1)?nr:1) * powmod((nr * nr )%m, k / 2, m)) % m;
    }

    static long pow(long n, long k){
        if (k == 0)
            return 1;
        return ((k%2==1)?1:n) * pow(n * n, k / 2);
    }

    static boolean is_prime_larger5000(long nr){
        if (nr < 5000 || nr % 2 == 0 )
            return false;
        for (int i = 3; i * i <= nr; i++)
            if (nr % i == 0)
                return false;
        return true;
    }

    static long generate_prime(){
        final Random rand = new Random();
        long ret;
        do{
            ret = rand.nextLong()%9000;
        }while (is_prime_larger5000(ret) == false);
        return ret;
    }

    static long cmmdc(long a, long b){
        if (b == 0)
            return a;
        return cmmdc(b, a %b);
    }

    static long modular_multiplicative_inverse(long a, long n){
//		taken from wikipedia RSA_(cryptosystem)#Operation
        long t = 0, nt = 1, r = n, nr = a % n, q, tmp;
        while (nr != 0){
            q = r / nr;
            tmp = nt;
            nt = t - q * nt;
            t = tmp;
            tmp = nr;
            nr = r - q * nr;
            r = tmp;
        }
        if (r > 1)
            return -1;
        if (t < 0)
            t += n;
        return t;
    }

    static void initialize_keys(){
        long a, b, phi;
        a = generate_prime();
        b = generate_prime();
        for_modulo = a * b;
        phi = (a - 1) * (b - 1);
        do{
            public_key = generate_prime();
        } while (cmmdc(public_key,phi) != 1);
        private_key = modular_multiplicative_inverse(public_key, phi);
    }

    static long get_public_key(){
        if (public_key == 0)
            initialize_keys();
        return public_key;
    }

    static long get_for_modulo(){
        if (for_modulo == 0)
            initialize_keys();
        return for_modulo;
    }

    public static long code(long message){
        return powmod(message, public_key, for_modulo);
    }

    public static long decode(long message){
        return powmod(message, private_key, for_modulo);
    }
}
