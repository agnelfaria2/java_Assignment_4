package dcst;

public class AcademicRecord implements Cloneable {
    private double averageMark;
    private String remark;
    public AcademicRecord(double averageMark, String remark) {
        this.averageMark = averageMark;
        this.remark = remark;
    }
    public void setRemark(String remark) { this.remark = remark; }
    public String getSummary() { return "Average: " + averageMark + " | Remark: " + remark; }
    @Override public AcademicRecord clone() throws CloneNotSupportedException {
        return (AcademicRecord) super.clone();
    }
}
