package Management;

public class Student {
    String StudentID;
    String StudentName;
    String Address;
    float Phone;

    public Student(String studentID, String studentName, String address, float phone) {
        StudentID = studentID;
        StudentName = studentName;
        Address = address;
        Phone = phone;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getPhone() {
        return Phone;
    }

    public void setPhone(float phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone=" + Phone +
                '}';
    }
}


