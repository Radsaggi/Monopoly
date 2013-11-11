/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoly;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author ashutosh
 */
public class Random {
    
    private java.util.Random r;
    private static final Random instance;
    
    static {
        instance = new Random();
    }

    private Random() {
        r = new java.util.Random();
    }
    
    public static Random getInstance() {
        return instance;
    }
    
    public int randomInt() {
        return randomInt(Integer.MAX_VALUE);
    }
    
    public int randomInt(int lim) {
        return ThreadLocalRandom.current().nextInt(lim);
    }
    
    public java.util.Random getR() {
        return ThreadLocalRandom.current();
    }

}
