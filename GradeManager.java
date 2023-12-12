public class GradeManager {
    
    public static float calculateRequired(float current, float goal, float finalWeight){
        return (goal - current * (1-finalWeight))/finalWeight;
    }

    public static float calculateGPA(int a, int b, int c, int d, int f){
        float GPA = ((a*4f)+(b*3f) + (c*2f) + d*1f)/(a + b + c + d +f);
        return GPA;
    }
}
