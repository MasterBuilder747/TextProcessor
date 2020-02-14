package CodeGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaterialProcessor {

    public static void readFile(String fileName) throws IOException {

        FileReader fr = new FileReader(fileName); //mac does not need to define the disk, uses / instead of \
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String s = br.readLine();
            System.out.println(s);

            if (s == null) {
                break;
            }
        }

        fr.close();
    }

    public static String dis(boolean b, String output) {
        if (b) {
            return "";
        }else{
            return output + ", ";
        }
    }

    public static boolean test(String input, String s) {
        return input.contains(s);
    }

    public static void main(String[] args) throws IOException {

        ///Users/Joseph/Desktop/ingots.txt
        FileReader fr = new FileReader("C:\\Users\\jaath\\Desktop\\all.txt"); //mac does not need to define the disk, uses / instead of \
        BufferedReader br = new BufferedReader(fr);
        while (true) {

            //read each line of the file
            String s = br.readLine();
            if (s == null) {
                break;
            }

            //generate list of materials in separate vars
            boolean plate = false;
            boolean dense_plate = false;
            boolean rod = false;
            boolean long_rod = false;
            boolean gear = false;
            boolean small_gear = false;
            boolean screw_bolt = false;
            boolean rotor = false;
            boolean foil = false;
            boolean ring = false;
            boolean frame = false;
            boolean lens = false;
            boolean spring = false;
            boolean fine_wire = false;

            //store the value of the material
            String mat = s.substring(0, s.indexOf(" ="));

            //check to see what the material has generated
            plate = test(s, "GENERATE_PLATE");
            dense_plate = test(s, "GENERATE_DENSE");
            rod = test(s, "GENERATE_ROD");
            long_rod = test(s, "GENERATE_LONG_ROD");
            frame = test(s, "GENERATE_FRAME");
            spring = test(s, "GENERATE_SPRING");
            gear = test(s, "GENERATE_GEAR");
            small_gear = test(s, "GENERATE_SMALL_GEAR");
            rotor = test(s, "GENERATE_ROTOR");
            ring = test(s, "GENERATE_RING");
            screw_bolt = test(s, "GENERATE_BOLT_SCREW");
            foil = test(s, "GENERATE_FOIL");
            fine_wire = test(s, "GENERATE_FINE_WIRE");

            //broader material values
            //STD_SOLID = GENERATE_PLATE | GENERATE_ROD | GENERATE_BOLT_SCREW | GENERATE_LONG_ROD;
            //STD_GEM = GENERATE_ORE | STD_SOLID | GENERATE_LENSE;
            //STD_METAL = GENERATE_PLATE;
            //EXT_METAL = STD_METAL | GENERATE_ROD | GENERATE_BOLT_SCREW | GENERATE_LONG_ROD;
            //EXT2_METAL = EXT_METAL | GENERATE_GEAR | GENERATE_FOIL | GENERATE_FINE_WIRE;
            if (s.contains("STD_SOLID")) {
                plate = true;
                rod = true;
                screw_bolt = true;
                long_rod = true;
            }
            if (s.contains("STD_GEM")) {
                plate = true;
                rod = true;
                screw_bolt = true;
                long_rod = true;
                lens = true;
            }
            if (s.contains("STD_METAL")) {
                plate = true;
            }
            if (s.contains("EXT_METAL")) {
                plate = true;
                rod = true;
                screw_bolt = true;
                long_rod = true;
            }
            if (s.contains("EXT2_METAL")) {
                plate = true;
                rod = true;
                screw_bolt = true;
                long_rod = true;
                gear = true;
                fine_wire = true;
                foil = true;
            }

            //display the line
            System.out.println(mat.toLowerCase() + ",");

            System.out.println(mat + ": "
                    + dis(plate, "plate")
                    + dis(dense_plate, "dense_plate")
                    + dis(rod, "rod")
                    + dis(long_rod, "long rod")
                    + dis(frame, "frame")
                    + dis(spring, "spring")
                    + dis(gear, "gear")
                    + dis(small_gear, "small_gear")
                    + dis(rotor, "rotor")
                    + dis(ring, "ring")
                    + dis(screw_bolt, "screw_bolt")
                    + dis(foil, "foil")
                    + dis(fine_wire, "fine_wire")
            );


        }
        fr.close();
    }
}
