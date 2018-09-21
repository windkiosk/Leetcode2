package leetcode.problems;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

public class P855_ExamRoom {

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
    }

    static class ExamRoom {

        static Seat MAX_LEFT;
        static Seat MAX_RIGHT;

        HashSet<Seat> seats;

        TreeMap<Segment, Integer> treeMap;

        int N;

        public ExamRoom(int N) {
            seats = new HashSet<>();
            MAX_LEFT = new Seat(-1, null, null);
            MAX_RIGHT = new Seat(N, null, null);
            treeMap = new TreeMap<>(Comparator.comparingInt(Segment::length));
            treeMap.put(new Segment(MAX_LEFT, MAX_RIGHT), 0);
            this.N = N;
        }

        public int seat() {
            Segment segment = treeMap.pollLastEntry().getKey();

            Seat seat;
            if (segment.left == MAX_LEFT) {
                seat = new Seat(0, MAX_LEFT, MAX_RIGHT);
                MAX_LEFT.right = seat;
                MAX_RIGHT.left = seat;
                treeMap.put(new Segment(seat, MAX_RIGHT), 0);
            } else if (segment.right == MAX_RIGHT) {
                seat = new Seat(N - 1, MAX_RIGHT.left, MAX_RIGHT);
                treeMap.put(new Segment(MAX_RIGHT.left, seat), 0);
                MAX_RIGHT.left.right = seat;
                MAX_RIGHT.left = seat;
            } else {
                int step = (segment.right.index - segment.left.index) / 2;
                seat = new Seat(segment.left.index + step, segment.left, segment.right);
                treeMap.put(new Segment(segment.left, seat), 0);
                treeMap.put(new Segment(seat, segment.right), 0);
            }

            return seat.index;
        }

        public void leave(int p) {

        }
    }

    static class Seat {
        int index;
        Seat left;
        Seat right;

        public Seat(int index, Seat left, Seat right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }

        public void setLeft(Seat left) {
            this.left = left;
        }

        public void setRight(Seat right) {
            this.right = right;
        }
    }

    static class Segment {
        Seat left;
        Seat right;

        public Segment(Seat left, Seat right) {
            this.left = left;
            this.right = right;
        }

        int length() {
            return right.index - left.index;
        }

    }

//    static class ExamRoom {
//        int N;
//        TreeSet<Integer> students;
//
//        public ExamRoom(int N) {
//            this.N = N;
//            students = new TreeSet<>();
//        }
//
//        public int seat() {
//            //Let's determine student, the position of the next
//            //student to sit down.
//            int student = 0;
//            if (students.size() > 0) {
//                //Tenatively, dist is the distance to the closest student,
//                //which is achieved by sitting in the position 'student'.
//                //We start by considering the left-most seat.
//                int dist = students.first();
//                Integer prev = null;
//                for (Integer s: students) {
//                    if (prev != null) {
//                        //For each pair of adjacent students in positions (prev, s),
//                        //d is the distance to the closest student;
//                        //achieved at position prev + d.
//                        int d = (s - prev) / 2;
//                        if (d > dist) {
//                            dist = d;
//                            student = prev + d;
//                        }
//                    }
//                    prev = s;
//                }
//
//                //Considering the right-most seat.
//                if (N - 1 - students.last() > dist)
//                    student = N - 1;
//            }
//
//            //Add the student to our sorted TreeSet of positions.
//            students.add(student);
//            return student;
//        }
//
//        public void leave(int p) {
//            students.remove(p);
//        }
//    }
}
