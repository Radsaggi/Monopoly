/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

/**
 *
 * @author ashutosh
 */
public class Company extends AbstractBean {

    private int money;
    private final String name;
    private int positionOnBoard;
    private int patents, missTurn;

    public static final String MONEY_VALUE_CHANGED_PROPERTY = "MoneyValueChangedProperty";

    public Company(String name) {
        this.name = name;

        money = 50_00;
        patents = 0;
        positionOnBoard = 0;
        missTurn = 0;
    }

    public int getPositionOnBoard() {
        return positionOnBoard;
    }

    public void setPositionOnBoard(int positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void decrMoney(int amt) {
        int oldMoney = money;
        money -= amt;
        firePropertyChange(MONEY_VALUE_CHANGED_PROPERTY, oldMoney, money);
    }

    public void incrMoney(int amt) {
        int oldMoney = money;
        money += amt;
        firePropertyChange(MONEY_VALUE_CHANGED_PROPERTY, oldMoney, money);
    }

    public String rollDice() {
        Board b = Board.getInstance();
        int extra = 0, dice = Random.getInstance().randomInt(6) + 1;
        b.getBlock(positionOnBoard).setCompany(null);
        positionOnBoard = (positionOnBoard + dice) % b.getBlockCount();
        while (b.getBlock(positionOnBoard).hasCompany()) {
            positionOnBoard = (positionOnBoard + 1) % b.getBlockCount();
            dice++;
        }
        b.getBlock(positionOnBoard).setCompany(this);
        return dice + (extra > 0 ? "+" + extra : "");
    }

    public boolean hasPatent() {
        return getPatents() > 0;
    }

    public int getPatents() {
        return patents;
    }

    public void incrPatentCount() {
        this.patents++;
    }

    public void decrPatentCount() {
        this.patents--;
    }

    public int getMissTurn() {
        return missTurn;
    }

    public void setMissTurn(int missTurn) {
        this.missTurn += missTurn;
    }
    
    public void completeOneJailSentence() {
        missTurn--;
    }

    @Override
    public String toString() {
        return getName();
    }

    public boolean isInJail() {
        return missTurn > 0;
    }
}
