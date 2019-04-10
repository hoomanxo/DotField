

import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*; 
public class Dot {
   
private double x, y;

Random rng = new Random() {
private Lock mutex = new ReentrantLock(); 

public double nextGaussian() {
mutex.lock();         
double result = super.nextGaussian();
mutex.unlock();
return result;
        }
    };


public Dot() {
x = rng.nextInt(501);
y = rng.nextInt(501);
}

public double getX() {
return x;
}

public double getY() {
return y;
}

public void move() {
x= x + rng.nextGaussian();
y= y + rng.nextGaussian();
}

}