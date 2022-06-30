package sort;

import java.util.*;

//첫 번째 매개변수가 더 작으면 음의정수, 같으면 0, 더 크면 양의정수를 반환시키도록 한다.	(오름차순)
public class sort_test2 {
    static List<Student> list;
    public static void main(String[] args) {
        Student[] s = new Student[5];
        s[0] = new Student("a",30);
        s[1] = new Student("b",100);
        s[2] = new Student("c",20);
        s[3] = new Student("d",0);
        s[4] = new Student("e",90);

        list = new ArrayList<>();
        list.addAll(Arrays.asList(s).subList(0, 5));

        Collections.sort(list);

        System.out.println("list.toString() = " + list.toString());



    }
    public static class Student implements Comparable<Student>{
        int score;
        String name;

        public Student( String name,int score) {
            this.score = score;
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }


        @Override
        public String toString() {
            return "Student{" +
                    "score=" + score +
                    ", name=" + name +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            System.out.println("list.toString = " + list.toString());
            System.out.println(o.name+"   "+this.name); //list[o] list[1]
            //return  o.score - this.score;   //내림차순 //3-10
            //return  this.score - o.score;   //오름차순
            
            if(this.score<o.getScore()){    //오름차순
                return -1;
            }else if(this.score>o.getScore()){
                return 1;
            }
                return 0;
            }
    }
}