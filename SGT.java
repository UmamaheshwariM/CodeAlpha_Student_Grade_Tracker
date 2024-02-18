import java.util.ArrayList;

class Subject {
    private String name;
    private List<Integer> grades;

    public Subject(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public int getHighest() {
        int highest = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public int getLowest() {
        int lowest = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}

class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double getAverage(String subjectName) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                return subject.getAverage();
            }
        }
        return 0.0;
    }

    public int getHighest(String subjectName) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                return subject.getHighest();
            }
        }
        return 0;
    }

    public int getLowest(String subjectName) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                return subject.getLowest();
            }
        }
        return 0;
    }
}

class GradeTracker {
    private List<Student> students;

    public GradeTracker() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
}
public static void main(String[] args) {
    GradeTracker gradeTracker = new GradeTracker();

    // Add students
    Student student1 = new Student("John Doe");
    Student student2 = new Student("Jane Doe");

    gradeTracker.addStudent(student1);
    gradeTracker.addStudent(student2);

    // Add subjects
    Subject math = new Subject("Math");
    Subject english = new Subject("English");

    student1.addSubject(math);
    student1.addSubject(english);

    student2.addSubject(math);
    student2.addSubject(english);

    // Add grades
    math.addGrade(85);
    math.addGrade(90);
