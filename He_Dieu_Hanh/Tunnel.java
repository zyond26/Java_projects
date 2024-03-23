package He_Dieu_Hanh;

public class Tunnel {
    char gateName;
    Tunnel(char gateName) {
        this.gateName = gateName;
        if (Vehicle_Spawn.key == 1) {
            if (Vehicle_Spawn.queueA > Test.capacity) {
                System.out.println("gac cong A yeu cau gac cong B dong cong \ngac cong A mo cong ");
                Vehicle_Spawn.queueA -= Test.capacity;
                System.out.println("co " + Test.capacity + " xe da qua ham ");
                System.out.println("so xe dang doi o cong A la " + Vehicle_Spawn.queueA);
                Vehicle_Spawn.key = 0;
            } else {
                System.out.println("gac cong A yeu cau gac cong B dong cong \ngac cong A mo cong ");
                System.out.println("co " + Vehicle_Spawn.queueA + " xe da qua ham ");
                Vehicle_Spawn.queueA -= Vehicle_Spawn.queueA;
                System.out.println("so xe dang doi o cong A la " + Vehicle_Spawn.queueA);
                Vehicle_Spawn.key = 0;
            }
        } else {
            if (Vehicle_Spawn.queueB > Test.capacity) {
                System.out.println("gac cong B yeu cau gac cong A dong cong \ngac cong B mo cong ");
                Vehicle_Spawn.queueB -= Test.capacity;
                System.out.println("co " + Test.capacity + " xe da qua ham ");
                System.out.println("so xe dang doi o cong B la " + Vehicle_Spawn.queueB);
                Vehicle_Spawn.key = 1;
            } else {
                System.out.println("gac cong B yeu cau gac cong A dong cong \ngac cong B mo cong ");
                System.out.println("co " + Vehicle_Spawn.queueB + " xe da qua ham ");
                Vehicle_Spawn.queueB -= Vehicle_Spawn.queueB;
                System.out.println("so xe dang doi o cong B la " + Vehicle_Spawn.queueB);
                Vehicle_Spawn.key = 1;
            }
        }
    }
}

