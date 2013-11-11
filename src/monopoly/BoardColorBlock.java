/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.awt.Color;

/**
 *
 * @author ashutosh
 */
public enum BoardColorBlock {

    VIOLET(null, "a405fd"), INDIGO(null, "065efe"), BLUE(null, "07f8f1"), GREEN(null, "00ff00"),
    YELLOW(null, "ffff00"), ORANGE(null, "ff7f00"), RED(null, "ff0000");

    private Operation operation;
    private final Color color;
    
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    static {
        shuffleOperations();
    }

    BoardColorBlock(Operation operation, String c) {
        this.operation = operation;
        int r = Integer.parseInt(c.substring(0, 2), 16);
        c = c.substring(2);
        int g = Integer.parseInt(c.substring(0, 2), 16);
        c = c.substring(2);
        int b = Integer.parseInt(c.substring(0, 2), 16);
        
        this.color = new Color(r, g, b, 150);
    }

    public Operation getOperation() {
        return operation;
    }

    private void setOperation(Operation o) {
        operation = o;
    }

    public Color getColor() {
        return color;
    }

    public static void shuffleOperations() {
        int i, n = 7;
        boolean z[] = new boolean[7];

        //GainOperation - 1 
        for (int j = 0; j < 1; j++) {
            i = Random.getInstance().randomInt(n--);
            while (z[i]) {
                i = (i + 1) % 7;
            }
            z[i] = true;
            set(i, new GainOperation());
        }

        //Loss Operation - 2
        for (int j = 0; j < 2; j++) {
            i = Random.getInstance().randomInt(n--);
            while (z[i]) {
                i = (i + 1) % 7;
            }
            z[i] = true;
            set(i, new LossOperation());
        }

        //SueOperation - 3
        for (int j = 0; j < 3; j++) {
            i = Random.getInstance().randomInt(n--);
            while (z[i]) {
                i = (i + 1) % 7;
            }
            z[i] = true;
            set(i, new SueOperation());
        }

        //PatentOperation - 1
        for (int j = 0; j < 1; j++) {
            i = Random.getInstance().randomInt(n--);
            while (z[i]) {
                i = (i + 1) % 7;
            }
            z[i] = true;
            set(i, new PatentOperation());
        }
    }

    private static void set(int idx, Operation o) {
        switch (idx) {
            case 0:
                VIOLET.setOperation(o);
                break;
            case 1:
                INDIGO.setOperation(o);
                break;
            case 2:
                BLUE.setOperation(o);
                break;
            case 3:
                GREEN.setOperation(o);
                break;
            case 4:
                YELLOW.setOperation(o);
                break;
            case 5:
                ORANGE.setOperation(o);
                break;
            case 6:
                RED.setOperation(o);
                break;
        }
    }

    public boolean hasCompany() {
        return company != null;
    }
}
