package iview.tes;
/*
You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.

Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.

Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)

Sample input 1: (arbitrarily ordered)
prereqs_courses1 = [
	["Foundations of Computer Science", "Operating Systems"],
	["Data Structures", "Algorithms"],
	["Computer Networks", "Computer Architecture"],
	["Algorithms", "Foundations of Computer Science"],
	["Computer Architecture", "Data Structures"],
	["Software Design", "Computer Networks"]
]

In this case, the order of the courses in the program is:
	Software Design
	Computer Networks
	Computer Architecture
	Data Structures
	Algorithms
	Foundations of Computer Science
	Operating Systems

Sample output 1:
	"Data Structures"


Sample input 2:
prereqs_courses2 = [
	["Data Structures", "Algorithms"],
	["Algorithms", "Foundations of Computer Science"],
	["Foundations of Computer Science", "Logic"]
]


Sample output 2:
	"Algorithms"
Sample input 3:
prereqs_courses3 = [
	["Data Structures", "Algorithms"],
]


Sample output 3:
	"Data Structures"

*/

import java.util.ArrayList;
import java.util.List;

public class KaratFindMiddleCourse {
    //TODO
    static List<String> findMiddleCourse(String[][] courseDependencies) {

        List<String> courses = buildCourseOrderFromDependency(courseDependencies);

        return findMiddleEntry(courses);

    }

    private static List<String> findMiddleEntry(List<String> courses) {
        List<String> subList;
        if (courses.size() % 2 == 0) {
            subList = courses.subList(((courses.size() - 1) / 2) + 1, ((courses.size() - 1) / 2) + 2);
        } else {
            subList = courses.subList((courses.size()) / 2, ((courses.size()) / 2) + 1);
        }
        System.out.println("subList: " + subList);
        return subList;
    }

    private static List<String> buildCourseOrderFromDependency(String[][] dependencies) {
        List<String> courses = new ArrayList<>();
        int[] visited = new int[dependencies.length];
        int remaining = dependencies.length;

        courses.add(dependencies[0][1]);
        courses.add(dependencies[0][0]);
        remaining--;
        visited[0] = 1;
        while (remaining > 0) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 0) {
                    if (courses.contains(dependencies[i][1])) {
                        courses.add(dependencies[i][0]);
                        remaining--;
                        visited[i] = 1;
                    } else if (courses.contains(dependencies[i][0])) {
                        courses.add(0, dependencies[i][1]);
                        remaining--;
                        visited[i] = 1;
                    }
                }
            }
        }

        System.out.println("courses: " + courses);

        return courses;

    }

    public static void main(String[] argv) {
        String[][] prereqsCourses1 = {
                {"Foundations of Computer Science", "Operating Systems"},
                {"Data Structures", "Algorithms"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };

        System.out.println(findMiddleCourse(prereqsCourses1));

        String[][] prereqsCourses2 = {
                {"Data Structures", "Algorithms"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Foundations of Computer Science", "Logic"}
        };

        System.out.println(findMiddleCourse(prereqsCourses2));

        String[][] prereqsCourses3 = {
                {"Data Structures", "Algorithms"}
        };

        System.out.println(findMiddleCourse(prereqsCourses3));

    }

}
