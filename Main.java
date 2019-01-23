package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Point> points = new ArrayList<Point>();

        points.add(new Point(0,1));
        points.add(new Point(2,1));
        points.add(new Point(-1,1));
        points.add(new Point(-1,-5));
        points.add(new Point(3,1));


        Stream<Point> pointStream = points.stream();
        Point res = pointStream.filter(p ->p.x < 0 ).findFirst().get();
        System.out.println(res);
        System.out.println("****************");

        Stream<Point> pointStream2 = points.stream();

        Function<Point,Point> scaleBy2 = e -> {

            e.x *=2 ;

            e.y *=2;

            return e;
        };

        Function<Point,Point> scaleByhalf = r -> {

            r.x /=2;
            r.y /= 2;
            return r;
        };

        pointStream2.map(scaleBy2).forEach(System.out::println);
        System.out.println("****************");

        Stream<Point> pointStream3 = points.stream();
        pointStream3.map(scaleByhalf).forEach(System.out::println);

        System.out.println("****************************");

        // media tuturor coordonatelor x si y ... punctul cel mai central

        Stream<Point> averageXStream = points.stream();

        Double averageX = averageXStream.mapToInt(p -> p.x).average().getAsDouble();

        System.out.println("AverageX "+averageX);

        System.out.println("****************************");

        Stream<Point> sortOrigin = points.stream();

        Comparator<Point> comparator = (p,q)->{

            Integer d1 = p.x*p.x + p.y*p.y;

            Integer d2 = q.x*q.x + q.y*q.y;

            return d1 -d2;
        };

        sortOrigin.sorted(comparator).forEach(System.out::println);

        System.out.println("****************************");



        Stream<Point> comparePoints = points.stream();

        comparePoints.sorted().forEach(System.out::println);

        System.out.println("****************************");

        Stream<Point> sumCoordonates  =points.stream();

         Point p = sumCoordonates.reduce(new Point(0,0),(currentVal,el)  ->{

            currentVal.x += el.x;

            currentVal.y += el.y;

            return currentVal;
        }
        );
        System.out.println(p);


        List<String> strings = new ArrayList<>();
        strings.add("Rand1");
        strings.add("Test");
        strings.add("Ceva");

        String res2 = strings.stream().reduce("",(currentVal,el) -> {

            if (! currentVal.equals("")) {

                String r = currentVal += " ," + el;

                return r;
            }else {

                return el;
            }
        }
        );

        System.out.println(res2);


    }
}
