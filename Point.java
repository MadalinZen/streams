package Streams;

public class Point implements Comparable {

    public Integer x ;
    public Integer y ;


    public Point(Integer x ,Integer y){

        this.x = x ;

        this.y = y ;
    }

    @Override

    public String toString(){

        return "(Point x : " + x + ", y : " + y + ")";
    }

    @Override
    public int compareTo(Object arg0){

        if (!(arg0 instanceof Point)){

            return 0;

        }

        Point p = (Point)arg0;

        Integer d1 = x*x + y*y;
        Integer d2 = p.x*p.x+p.y*p.y;

        return d1-d2;
    }
}
