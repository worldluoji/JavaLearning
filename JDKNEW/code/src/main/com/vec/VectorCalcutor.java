package src.main.com.vec;

import src.main.com.returned.Returned;

/** 
**  孵化期的特性, OPEN JDK17目前没有，最新版本JDK才有
**  求 y = a0x0 + a1x1 + ... + anxn
**  性能比写for循环快10倍
**/
public class VectorCalcutor {
    // public static void main(String[] args) {
        
    //     final float[] a = new float[] {0.6F, 0.7F, 0.8F, 0.9F};
    //     final FloatVector va =
    //             FloatVector.fromArray(FloatVector.SPECIES_128, a, 0);
                
    //     final float[] x = new float[] {1.0F, 2.0F, 3.0F, 4.0F};
    //     final FloatVector vx =
    //             FloatVector.fromArray(FloatVector.SPECIES_128, x, 0);
    // }

    
    // private static Returned<Float> sumInVector(FloatVector va, FloatVector vx) {
    //     if (va == null || vx == null || va.length() != vx.length()) {
    //         return new Returned.ErrorCode(-1);
    //     }
        
    //     // FloatVector vy = va.mul(vx);
    //     float[] y = va.mul(vx).toArray();
        
    //     float r = 0F;
    //     for (int i = 0; i < y.length; i++) {
    //         r += y[i];
    //     }
    //     return new Returned.ReturnValue<>(r);
    // }
}
