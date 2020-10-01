package iview.tes;

import java.util.*;

public class KaratFindCommonCourseOfPairOfStudents {

    static Map<String, Set<String>> findCommonCourses(String[][] input) {
        Map<String, Set<String>> studentCourses = buildStudentCourses(input);
        List<String> students = getStudents(studentCourses);
        List<String[]> pairOfStudents = buildStudentsPair(students);
        return findCommonCoursesOfPair(studentCourses, pairOfStudents);
    }

    private static Map<String, Set<String>> findCommonCoursesOfPair(Map<String, Set<String>> studentCourses, List<String[]> pairOfStudents) {
        Map<String, Set<String>> pairCommonCourses = new HashMap<>();
        for (String[] pair : pairOfStudents) {
            String studentId1 = pair[0];
            String studentId2 = pair[1];

            Set<String> commonCourses = new HashSet<>(studentCourses.get(studentId1));
            commonCourses.retainAll(studentCourses.get(studentId2));
            pairCommonCourses.put(studentId1 + "," + studentId2, commonCourses);
        }
        return pairCommonCourses;
    }

    private static List<String[]> buildStudentsPair(List<String> students) {
        List<String[]> pairOfStudents = new ArrayList();
        for (int entry = 0; entry < students.size(); entry++) {
            for (int nextEntry = entry + 1; nextEntry < students.size(); nextEntry++) {
                String[] pair = new String[2];
                pair[0] = students.get(entry);
                pair[1] = students.get(nextEntry);
                pairOfStudents.add(pair);
            }
        }
        return pairOfStudents;
    }

    private static List<String> getStudents(Map<String, Set<String>> studentCourses) {
        List<String> students = new ArrayList();
        for (String studentId : studentCourses.keySet()) {
            students.add(studentId);
        }
        return students;
    }

    private static Map<String, Set<String>> buildStudentCourses(String[][] input) {
        Map<String, Set<String>> studentCourses = new HashMap<>();
        for (int entry = 0; entry < input.length; entry++) {
            String studentId = input[entry][0];
            String course = input[entry][1];

            if (studentCourses.containsKey(studentId)) {
                studentCourses.get(studentId).add(course);
            } else {
                Set<String> courses = new HashSet<>();
                courses.add(course);
                studentCourses.put(studentId, courses);
            }
        }
        return studentCourses;
    }

    public static void main(String[] argv) {
        String[][] studentCoursePairs1 = {
                {"94", "Math"},
                {"25", "Science"},
                {"17", "Economics"},
                {"25", "Math"},
                {"17", "English"},
                {"18", "Science"}
        };

        String[][] studentCoursePairs2 = {
                {"94", "Math"},
                {"25", "Science"},
                {"17", "Economics"},
                {"17", "English"},
        };

        System.out.println(findCommonCourses(studentCoursePairs1));

        System.out.println(findCommonCourses(studentCoursePairs2));

    }
}
