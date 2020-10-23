/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmatic;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Kyle
 */
public class Crewmatic {

    enum Movement {
        UP,
        DOWN,
        LEFT,
        RIGHT,
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException {
        Tree Skeld = new Tree("Skeld");
        Node n_1 = Skeld.makeNode("n_1", 835, 116);
        Node n_2 = Skeld.makeNode("n_2", 1200, 140);
        Node n_4 = Skeld.makeNode("n_4", 1200, 179);
        Node n_5 = Skeld.makeNode("n_5", 1240, 179);
        Node n_3 = Skeld.makeNode("n_3", 1415, 178);
        Node n_8 = Skeld.makeNode("n_8", 1415, 206);
        Node n_7 = Skeld.makeNode("n_7", 422, 204);
        Node n_9 = Skeld.makeNode("n_9", 1462, 206);
        Node n_10 = Skeld.makeNode("n_10", 1055, 222);
        Node n_12 = Skeld.makeNode("n_12", 1462, 238);
        Node n_11 = Skeld.makeNode("n_11", 1090, 222);
        Node n_13 = Skeld.makeNode("n_13", 1500, 238);
        Node n_15 = Skeld.makeNode("n_15", 1200, 268);
        Node n_16 = Skeld.makeNode("n_16", 1240, 268);
        Node n_17 = Skeld.makeNode("n_17", 1444, 268);
        Node n_18 = Skeld.makeNode("n_18", 1462, 268);
        Node n_19 = Skeld.makeNode("n_19", 422, 269);
        Node n_14 = Skeld.makeNode("n_14", 1090, 268);
        Node n_21 = Skeld.makeNode("n_21", 835, 269);
        Node n_20 = Skeld.makeNode("n_20", 680, 269);
        Node n_22 = Skeld.makeNode("n_22", 941, 269);
        Node n_23 = Skeld.makeNode("n_23", 941, 330);
        Node n_24 = Skeld.makeNode("n_24", 1019, 330);
        Node n_25 = Skeld.makeNode("n_25", 1090, 330);
        Node n_27 = Skeld.makeNode("n_27", 352, 359);
        Node n_6 = Skeld.makeNode("n_6", 350, 204);
        Node n_26 = Skeld.makeNode("n_26", 271, 359);
        Node n_29 = Skeld.makeNode("n_29", 1722, 424);
        Node n_31 = Skeld.makeNode("n_31", 144, 425);
        Node n_30 = Skeld.makeNode("n_30", 1748, 424);
        Node n_28 = Skeld.makeNode("n_28", 422, 359);
        Node n_33 = Skeld.makeNode("n_33", 1748, 434);
        Node n_35 = Skeld.makeNode("n_35", 1311, 440);
        Node n_36 = Skeld.makeNode("n_36", 1321, 440);
        Node n_34 = Skeld.makeNode("n_34", 1764, 434);
        Node n_37 = Skeld.makeNode("n_37", 1391, 440);
        Node n_39 = Skeld.makeNode("n_39", 1391, 452);
        Node n_38 = Skeld.makeNode("n_38", 1321, 452);
        Node n_41 = Skeld.makeNode("n_41", 1536, 452);
        Node n_42 = Skeld.makeNode("n_42", 1295, 460);
        Node n_43 = Skeld.makeNode("n_43", 1321, 460);
        Node n_44 = Skeld.makeNode("n_44", 680, 496);
        Node n_40 = Skeld.makeNode("n_40", 1444, 452);
        Node n_45 = Skeld.makeNode("n_45", 739, 496);
        Node n_46 = Skeld.makeNode("n_46", 774, 496);
        Node n_47 = Skeld.makeNode("n_47", 1652, 500);
        Node n_32 = Skeld.makeNode("n_32", 173, 425);
        Node n_49 = Skeld.makeNode("n_49", 1652, 507);
        Node n_51 = Skeld.makeNode("n_51", 1748, 507);
        Node n_48 = Skeld.makeNode("n_48", 1536, 507);
        Node n_53 = Skeld.makeNode("n_53", 1748, 522);
        Node n_54 = Skeld.makeNode("n_54", 1804, 522);
        Node n_56 = Skeld.makeNode("n_56", 411, 524);
        Node n_55 = Skeld.makeNode("n_55", 352, 524);
        Node n_57 = Skeld.makeNode("n_57", 173, 544);
        Node n_50 = Skeld.makeNode("n_50", 1722, 507);
        Node n_52 = Skeld.makeNode("n_52", 739, 520);
        Node n_59 = Skeld.makeNode("n_59", 1439, 566);
        Node n_61 = Skeld.makeNode("n_61", 1113, 589);
        Node n_58 = Skeld.makeNode("n_58", 352, 544);
        Node n_62 = Skeld.makeNode("n_62", 1160, 590);
        Node n_64 = Skeld.makeNode("n_64", 1113, 601);
        Node n_60 = Skeld.makeNode("n_60", 1536, 566);
        Node n_66 = Skeld.makeNode("n_66", 1160, 627);
        Node n_63 = Skeld.makeNode("n_63", 1019, 601);
        Node n_67 = Skeld.makeNode("n_67", 1278, 627);
        Node n_65 = Skeld.makeNode("n_65", 1160, 601);
        Node n_69 = Skeld.makeNode("n_69", 684, 643);
        Node n_71 = Skeld.makeNode("n_71", 659, 656);
        Node n_72 = Skeld.makeNode("n_72", 684, 656);
        Node n_73 = Skeld.makeNode("n_73", 743, 656);
        Node n_74 = Skeld.makeNode("n_74", 804, 656);
        Node n_75 = Skeld.makeNode("n_75", 978, 708);
        Node n_70 = Skeld.makeNode("n_70", 804, 650);
        Node n_76 = Skeld.makeNode("n_76", 1019, 708);
        Node n_68 = Skeld.makeNode("n_68", 659, 643);
        Node n_77 = Skeld.makeNode("n_77", 315, 727);
        Node n_80 = Skeld.makeNode("n_80", 1439, 748);
        Node n_79 = Skeld.makeNode("n_79", 427, 727);
        Node n_81 = Skeld.makeNode("n_81", 1488, 748);
        Node n_83 = Skeld.makeNode("n_83", 1070, 752);
        Node n_78 = Skeld.makeNode("n_78", 352, 727);
        Node n_82 = Skeld.makeNode("n_82", 1019, 752);
        Node n_85 = Skeld.makeNode("n_85", 743, 780);
        Node n_86 = Skeld.makeNode("n_86", 427, 791);
        Node n_87 = Skeld.makeNode("n_87", 556, 791);
        Node n_84 = Skeld.makeNode("n_84", 660, 780);
        Node n_88 = Skeld.makeNode("n_88", 1070, 820);
        Node n_90 = Skeld.makeNode("n_90", 1439, 820);
        Node n_92 = Skeld.makeNode("n_92", 427, 869);
        Node n_93 = Skeld.makeNode("n_93", 1367, 904);
        Node n_89 = Skeld.makeNode("n_89", 1266, 820);
        Node n_91 = Skeld.makeNode("n_91", 295, 869);
        Node n_94 = Skeld.makeNode("n_94", 1439, 904);
        Node n_96 = Skeld.makeNode("n_96", 1266, 906);
        Node n_95 = Skeld.makeNode("n_95", 1240, 906);
        Node n_99 = Skeld.makeNode("n_99", 660, 910);
        Node n_97 = Skeld.makeNode("n_97", 1288, 906);
        Node n_100 = Skeld.makeNode("n_100", 937, 910);
        Node n_101 = Skeld.makeNode("n_101", 937, 1017);
        Node n_102 = Skeld.makeNode("n_102", 1070, 1017);
        Skeld.connect(n_1, n_21);
        Node n_98 = Skeld.makeNode("n_98", 556, 910);
        Skeld.connect(n_2, n_4);
        Skeld.connect(n_4, n_5);
        Skeld.connect(n_4, n_15);
        Skeld.connect(n_6, n_7);
        Skeld.connect(n_5, n_16);
        Skeld.connect(n_7, n_19);
        Skeld.connect(n_8, n_9);
        Skeld.connect(n_9, n_12);
        Skeld.connect(n_10, n_11);
        Skeld.connect(n_3, n_8);
        Skeld.connect(n_11, n_14);
        Skeld.connect(n_12, n_13);
        Skeld.connect(n_12, n_18);
        Skeld.connect(n_14, n_15);
        Skeld.connect(n_16, n_17);
        Skeld.connect(n_14, n_25);
        Skeld.connect(n_17, n_40);
        Skeld.connect(n_19, n_20);
        Skeld.connect(n_15, n_16);
        Skeld.connect(n_17, n_18);
        Skeld.connect(n_19, n_28);
        Skeld.connect(n_20, n_44);
        Skeld.connect(n_22, n_23);
        Skeld.connect(n_23, n_24);
        Skeld.connect(n_20, n_21);
        Skeld.connect(n_24, n_63);
        Skeld.connect(n_24, n_25);
        Skeld.connect(n_26, n_27);
        Skeld.connect(n_27, n_28);
        Skeld.connect(n_27, n_55);
        Skeld.connect(n_21, n_22);
        Skeld.connect(n_30, n_33);
        Skeld.connect(n_29, n_50);
        Skeld.connect(n_31, n_32);
        Skeld.connect(n_29, n_30);
        Skeld.connect(n_33, n_51);
        Skeld.connect(n_32, n_57);
        Skeld.connect(n_36, n_38);
        Skeld.connect(n_37, n_39);
        Skeld.connect(n_38, n_39);
        Skeld.connect(n_33, n_34);
        Skeld.connect(n_35, n_36);
        Skeld.connect(n_40, n_41);
        Skeld.connect(n_39, n_40);
        Skeld.connect(n_38, n_43);
        Skeld.connect(n_44, n_45);
        Skeld.connect(n_42, n_43);
        Skeld.connect(n_45, n_46);
        Skeld.connect(n_41, n_48);
        Skeld.connect(n_45, n_52);
        Skeld.connect(n_47, n_49);
        Skeld.connect(n_48, n_49);
        Skeld.connect(n_48, n_60);
        Skeld.connect(n_49, n_50);
        Skeld.connect(n_50, n_51);
        Skeld.connect(n_53, n_54);
        Skeld.connect(n_51, n_53);
        Skeld.connect(n_55, n_56);
        Skeld.connect(n_55, n_58);
        Skeld.connect(n_57, n_58);
        Skeld.connect(n_58, n_78);
        Skeld.connect(n_59, n_60);
        Skeld.connect(n_59, n_80);
        Skeld.connect(n_61, n_64);
        Skeld.connect(n_62, n_65);
        Skeld.connect(n_63, n_64);
        Skeld.connect(n_63, n_76);
        Skeld.connect(n_64, n_65);
        Skeld.connect(n_65, n_66);
        Skeld.connect(n_66, n_67);
        Skeld.connect(n_68, n_71);
        Skeld.connect(n_69, n_72);
        Skeld.connect(n_70, n_74);
        Skeld.connect(n_71, n_72);
        Skeld.connect(n_72, n_73);
        Skeld.connect(n_73, n_74);
        Skeld.connect(n_73, n_85);
        Skeld.connect(n_75, n_76);
        Skeld.connect(n_76, n_82);
        Skeld.connect(n_77, n_78);
        Skeld.connect(n_78, n_79);
        Skeld.connect(n_79, n_86);
        Skeld.connect(n_80, n_90);
        Skeld.connect(n_80, n_81);
        Skeld.connect(n_82, n_83);
        Skeld.connect(n_83, n_88);
        Skeld.connect(n_84, n_85);
        Skeld.connect(n_84, n_99);
        Skeld.connect(n_86, n_87);
        Skeld.connect(n_86, n_92);
        Skeld.connect(n_87, n_98);
        Skeld.connect(n_88, n_102);
        Skeld.connect(n_88, n_89);
        Skeld.connect(n_89, n_90);
        Skeld.connect(n_89, n_96);
        Skeld.connect(n_90, n_94);
        Skeld.connect(n_91, n_92);
        Skeld.connect(n_93, n_94);
        Skeld.connect(n_95, n_96);
        Skeld.connect(n_96, n_97);
        Skeld.connect(n_98, n_99);
        Skeld.connect(n_99, n_100);
        Skeld.connect(n_100, n_101);
        Skeld.connect(n_101, n_102);

        n_91.setPositionException(288, 854);
        n_67.setPositionException(1290, 646);

        Task Wire=new Wires();
        n_1.associated_task = Wire;
        n_56.associated_task = Wire;
        n_61.associated_task = Wire;
        n_47.associated_task = Wire;
        n_73.associated_task = Wire;
        n_75.associated_task = Wire;

        n_67.associated_task = new CardSwipe();

        n_31.associated_task = new Manifolds();
        
        Task D_U=new DownloadUpload();
        n_73.associated_task = D_U;
        n_95.associated_task = D_U;
        n_62.associated_task = D_U;
        n_30.associated_task = D_U;
        n_3.associated_task = D_U;
        n_2.associated_task = D_U;

        Thread.sleep(1000);
        Player me = new Player(new Robot(), n_10, 1, (new Color(107, 47, 188)));
        NodeArray task_list = me.findTasks(Skeld);
        while (task_list.getLength() > 0) {
            int shortest_pos = 0;
            PathConnection shortest = Skeld.Path(me.getLocation().getId(), task_list.main[0].getId());
            for (int i = 1; i < task_list.getLength(); i++) {
                PathConnection challenge = Skeld.Path(me.getLocation().getId(), task_list.main[i].getId());
                if (challenge.distance < shortest.distance) {
                    shortest = challenge;
                    shortest_pos = i;
                }
            }
            me.followPath(shortest);
            //Now at location
            task_list.main[shortest_pos].associated_task.execute();
            Thread.sleep(1000);

            task_list.pop(shortest_pos);
            if (task_list.getLength() == 0) {
                task_list = me.findTasks(Skeld);
            }
            //Thread.sleep(5000);
        }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Where to?");
//        while (sc.hasNext()) {
//
//            PathConnection pl = Skeld.Path(me.getLocation().getId(), sc.nextLine());
//            Thread.sleep(2000);
//            me.followPath(pl);
//            System.out.println("Where to?");
//        }
    }

}
