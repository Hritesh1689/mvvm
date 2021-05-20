package com.agicent.mvvmdemo.Activity.backtraking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class PointsOnAPlane {
//    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
//
//    }

    public String getSlope(Point p1,Point p2){
        if(p1.x-p2.x==0) return "INF";
        if(p1.y-p2.y==0) return "0";

        long xDiff=(long)p2.x-(long)p1.x;
        long yDiff=(long)p2.y-(long)p1.y;

        long g=findGCD(xDiff,yDiff);
         String sign=(xDiff>0 && yDiff>0) || (xDiff<0 && yDiff<0) ? "":"-";
         return sign+(Math.abs(yDiff)/g)+"/"+(Math.abs(xDiff)/g);
    }

    private long findGCD(long xDiff, long yDiff) {
        if(xDiff<yDiff) return findGCD(yDiff,xDiff);

        if(yDiff==0) return xDiff;
        return findGCD(yDiff,xDiff%yDiff);
    }

    class Point{
        int x;
        int y;

        Point(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;


//            if(o instanceof Point){
//                Point p1 = (Point)o;
//                return this.x == p1.x && this.y == p1.y;
//            }
//            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
           // return (this.x+"-"+this.y).hashCode();
        }
    }
}
