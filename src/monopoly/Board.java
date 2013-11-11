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
public class Board extends monopoly.AbstractBean {

    private Company[] companies;
    private BoardColorBlock blocks[];
    private int companyCount, index;
    private static final int NUMBER_OF_BLOCKS = 25;

    public static final String COMPANY_COUNT_PROPERTY = "CompanyCountProperty",
            COMPANY_ORDER_PROPERTY = "CompanOrderProperty";
    public static final int MONEY_MULTPLE = 1_000,
            JAIL_MISS_TURNS = 1;

    private static final Board instance;

    static {
        instance = new Board();
    }

    private Board() {
        companies = new Company[10];
        blocks = new BoardColorBlock[NUMBER_OF_BLOCKS];
        index = 0;
        companyCount = 0;
        initBlocks();
    }

    public static Board getInstance() {
        return instance;
    }

    public Company getNextCompany() {
        Company c = null;
        do {
            if (c != null) {
                c.completeOneJailSentence();
            }
            c = companies[index];
            index = (index + 1) % companyCount;
            System.out.println(c + " selected");
            firePropertyChange(COMPANY_ORDER_PROPERTY, null, null);
        } while (c.isInJail());
        return c;
    }

    public void addCompany(Company c) {
        //add to list
        checkSize();
        companies[companyCount] = c;
        System.out.println(c + " is at " + companyCount);
        companyCount++;

        //assign a block
        int idx = Random.getInstance().randomInt(NUMBER_OF_BLOCKS - getCompanyCount());
        while (blocks[idx].hasCompany()) {
            idx = (idx + 1) % NUMBER_OF_BLOCKS;
        }
        c.setPositionOnBoard(idx);
        blocks[idx].setCompany(c);

        firePropertyChange(COMPANY_COUNT_PROPERTY, companyCount - 1, companyCount);
    }

    public Company getRandomCompany() {
        int idx = Random.getInstance().randomInt(companyCount);
        return companies[idx];
    }
    
    public Company getRandomCompany(Company not) {
        int idx = Random.getInstance().randomInt(companyCount - 1);
        return companies[idx] == not ? companies[idx + 1] : companies[idx];
    }

    public Company randomCompany(Company c) {
        int idx = Random.getInstance().randomInt(companyCount - 1);
        return c != companies[idx] ? companies[idx] : companies[companyCount - 1];
    }

    public int getCompanyCount() {
        return companyCount;
    }

    private void initBlocks() {
        blocks = new BoardColorBlock[36];
        blocks[0] = BoardColorBlock.RED;
        blocks[1] = BoardColorBlock.ORANGE;
        blocks[2] = BoardColorBlock.YELLOW;
        blocks[3] = BoardColorBlock.GREEN;
        blocks[4] = BoardColorBlock.BLUE;
        blocks[5] = BoardColorBlock.INDIGO;
        blocks[6] = BoardColorBlock.VIOLET;
        blocks[7] = BoardColorBlock.RED;
        blocks[8] = BoardColorBlock.ORANGE;
        blocks[9] = BoardColorBlock.GREEN;
        blocks[10] = BoardColorBlock.YELLOW;
        blocks[11] = BoardColorBlock.ORANGE;
        blocks[12] = BoardColorBlock.RED;
        blocks[13] = BoardColorBlock.VIOLET;
        blocks[14] = BoardColorBlock.INDIGO;
        blocks[15] = BoardColorBlock.BLUE;
        blocks[16] = BoardColorBlock.GREEN;
        blocks[17] = BoardColorBlock.YELLOW;
        blocks[18] = BoardColorBlock.ORANGE;
        blocks[19] = BoardColorBlock.RED;
        blocks[20] = BoardColorBlock.VIOLET;
        blocks[21] = BoardColorBlock.INDIGO;
        blocks[22] = BoardColorBlock.BLUE;
        blocks[23] = BoardColorBlock.GREEN;
        blocks[24] = BoardColorBlock.YELLOW;
        blocks[25] = BoardColorBlock.ORANGE;
        blocks[26] = BoardColorBlock.RED;
        blocks[27] = BoardColorBlock.ORANGE;
        blocks[28] = BoardColorBlock.RED;
        blocks[29] = BoardColorBlock.VIOLET;
        blocks[30] = BoardColorBlock.INDIGO;
        blocks[31] = BoardColorBlock.BLUE;
        blocks[32] = BoardColorBlock.GREEN;
        blocks[33] = BoardColorBlock.YELLOW;
        blocks[34] = BoardColorBlock.ORANGE;
        blocks[35] = BoardColorBlock.RED;
    }

    public BoardColorBlock getBlock(int i) {
        return blocks[i];
    }

    public Company getCompany(int idx) {
        return companies[idx];
    }

    public Company[] getCompanies() {
        return companies;
    }

    private void checkSize() {
        if (companyCount < companies.length) {
            return;
        }

        int n = companies.length;
        Company temp[] = new Company[2 * n];
        System.arraycopy(companies, 0, temp, 0, n);
        companies = temp;
    }

    public int getBlockCount() {
        return blocks.length;
    }

    public int getSelectIndex() {
        return index;
    }
}
