/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import javax.swing.JOptionPane;

/**
 *
 * @author ashutosh
 */
public abstract class Operation {

    public abstract String perform(Company which);

    protected int randomAmount(int min, int max, int steps) {
        int l = (max - min) / steps;
        int random = Random.getInstance().randomInt(l);
        return (random * steps) + min;
    }
}

class GainOperation extends Operation {

    private String msg[] = new String[]{
        "Your Company has successfully launched a new product into the market increasing the worth of the company by %d",
        "The Recent boom in the market has turned out to be quite productive for your company fetching a profit of %d",
        "The new marketing stratergy has proved to be a success generating a profit of %d"};

    @Override
    public String perform(Company which) {
        int amt = randomAmount(25, 5_00, 25);
        int amt1 = amt;
        for (int i = 0; i < which.getPatents() * 2; i++) {
            int a = randomAmount(25, 5_00, 25);
            if (a > amt) {
                amt = a;
            }
        }
        which.incrMoney(amt);
        String ret = getMessage(amt);
        if (which.hasPatent() && amt != amt1) {
            ret += ". Patents increased amount from Rs. " + amt1 + "k";
        }
        return ret;
    }

    protected String getMessage(int amt) {
        String ar[] = getMessages();
        int random = Random.getInstance().randomInt(ar.length);
        return ar[random].replace("%d", "Rs. " + Integer.toString(amt) + "k");
    }

    protected String[] getMessages() {
        return msg;
    }
}

class LossOperation extends Operation {

    private String msg[] = new String[]{
        "The recession has cost the company %d",
        "Due to certain equipment damage a loss of %d is projected",
        "The new Marketing plan was a failure, it has cost the company %d"};

    @Override
    public String perform(Company which) {
        int amt = randomAmount(25, 5_00, 25);
        int amt1 = amt;
        for (int i = 0; i < which.getPatents() * 2; i++) {
            int a = randomAmount(25, 5_00, 25);;
            if (a < amt) {
                amt = a;
            }
        }

        int r = which.hasPatent() ? Random.getInstance().randomInt(which.getPatents()) : 0;

        if (!which.hasPatent() || r == 0) {
            which.decrMoney(amt);
            String ret = getMessage(amt);
            if (which.hasPatent() && amt != amt1) {
                ret += ". Patents decreased amount from Rs. " + amt1 + "k";
            }
            return ret;
        } else {
            which.incrMoney(amt);
            return "Patents helped you, you earned Rs. " + amt + "k";
        }
    }

    protected String getMessage(int amt) {
        String ar[] = getMessages();
        int random = Random.getInstance().randomInt(ar.length);
        return ar[random].replace("%d", "Rs. " + Integer.toString(amt) + "k");
    }

    protected String[] getMessages() {
        return msg;
    }
}

class SueOperation extends Operation {

    private final String ar[] = new String[]{
        "Pay the amount",
        "Deal under the table",
        "Go to JAIL"
    };

    @Override
    public String perform(Company which) {
        int i = Random.getInstance().randomInt(4);
        Company c1, c2;
        if (i != 0) {
            //You sue
            c1 = which;
            c2 = Board.getInstance().getRandomCompany(which);
        } else {
            //You are sued
            c1 = Board.getInstance().getRandomCompany(which);
            c2 = which;
        }

        int amt = super.randomAmount(1000, 1500, 50);

        String msg = c1.toString() + " has sued " + c2.toString() + "."
                + "\nThe amount at stake is " + "Rs. " + amt + "k" + "."
                + "\nWhat will you do ? ";
        String ar[] = getOptions();
        String sel = (String) JOptionPane.showInputDialog(null, msg, "Law Suit",
                JOptionPane.QUESTION_MESSAGE, null, ar, ar[0]);

        if (sel.equals(ar[0])) {
            c2.decrMoney(amt);
            c1.incrMoney(amt);
            return c2.toString() + " paid " + c1.toString()
                    + " an amount of Rs. " + amt + "k";
        } else if (sel.equals(ar[1])) {
            String in = JOptionPane.showInputDialog(null, "Enter the deal amount.",
                    "Under the table DEAL", JOptionPane.QUESTION_MESSAGE);
            try {
                amt = Integer.parseInt(in);
                c2.decrMoney(amt);
                c1.incrMoney(amt);
                return c2.toString() + " paid " + c1.toString()
                        + " an amount of Rs. " + amt + "k";
            } catch (NumberFormatException ex) {
            }
            return "Incorrect Input! Transcation failed.";
        } else {
            c2.setMissTurn(Board.JAIL_MISS_TURNS);

            int reduc = Random.getInstance().randomInt(amt);
            reduc++;
            c2.decrMoney(reduc);

            return c2.toString() + " has gone to JAIL. Bank has taken Rs. " + reduc + "k from him.";
        }
    }

    protected String[] getOptions() {
        return ar;
    }
}

class PatentOperation extends Operation {

    @Override
    public String perform(Company which) {
        int n = Random.getInstance().randomInt(6);
        String in = JOptionPane.showInputDialog(null, "You have landed on the Patents tile. "
                + "Enter 0-5 to try your luck!", "Patents Tile", JOptionPane.QUESTION_MESSAGE);
        try {
            int val = Integer.parseInt(in);
            if (val == n) {
                which.incrPatentCount();
                return "You are in luck today. You have just acquired a new patent.";
            }
        } catch (NumberFormatException ex) {
        }
        return "hard Luck better try next time! (" + n + ")";
    }
}
