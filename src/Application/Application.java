package Application;

import CustomErrors.ApplicationErrors;
import Necklace.Necklace;
import Necklace.NecklaceActions;
import Stones.StoneParameters.ClarityType;
import Stones.StoneParameters.GemCuttingType;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Application {


    public static void main(String[] args) throws ApplicationErrors, FileNotFoundException {


        Necklace necklace = new Necklace();
        NecklaceActions necklaceActions = new NecklaceActions();
        Scanner str = new Scanner(System.in);
        String menuSelector = "";
        Results results = new Results();

        printMenu();

        // creating the necklace

        System.out.println("Insert number of stones in the Necklace");
        String stoneNumbers = str.next();
        if (stoneNumbers.equals("Q") || stoneNumbers.equals("q"))
        {
            System.exit(0);
        }
        else {
            try {
                int number = Integer.parseInt(stoneNumbers);
                System.out.println("Created necklace successfully added to file Necklace.txt");
                results.writeResults("Necklace.txt", necklaceActions.createNecklace(necklace, number).toString());

                System.out.println("\n Necklace Weight = " + String.format("%.2f",necklaceActions.calculateStoneWeight(necklace.getList())));
                System.out.println("\n Necklace Price = " + String.format("%.2f",necklaceActions.calculateStonesPrice(necklace.getList())));
            } catch (NumberFormatException e) {
                throw new ApplicationErrors("Incorrect number", e);
            }
        }

        // selecting the actions


        while (!menuSelector.equals("Q") || !menuSelector.equals("q")) {

            menuSelector = str.next();

            if (menuSelector.equals("Q") || menuSelector.equals("q")){
                break;
            }
            else {
                try {
                    int selector = Integer.parseInt(menuSelector);
                    switch (selector) {
                        case 1:
                            {
                                System.out.println("\n Sorted by Price Necklace successfully added to file SortedNecklace.txt\n");
                                results.writeResults("SortedNecklace.txt",necklaceActions.sortStonesByPrice(necklace.getList()).toString());

                            }continue;
                        case 2: {
                                System.out.println("\n Sorted by Gem Cutting Necklace successfully added to file SortedNecklace.txt\n");
                                results.writeResults("SortedNecklace.txt", necklaceActions.sortStonesByGemCutting(necklace.getList()).toString());
                            }continue;
                        case 3: {
                                System.out.println("Filter Stones by Gem Cut" + "\n Possible Gem Cunt are \n" + Arrays.toString(GemCuttingType.values()));
                                System.out.println("Insert needed Gem Cut");
                                String value = str.next();
                                System.out.println("filtered information successfully added to file filteredNecklace.txt");
                                results.writeResults("filteredNecklace.txt",necklaceActions.findStoneByGemCut(value, necklace.getList()).toString() );
                                System.out.println("\n Necklace Weight = " + String.format("%.2f",necklaceActions.calculateStoneWeight(necklaceActions.findStoneByGemCut(value,necklace.getList()))));
                                System.out.println("\n Necklace Price = " + String.format("%.2f",necklaceActions.calculateStonesPrice(necklaceActions.findStoneByGemCut(value,necklace.getList()))));
                            }continue;
                        case 4: {
                                try {
                                    System.out.println("Sorting Necklace by Price diapason.");
                                    System.out.println("Insert minimum price\n");
                                    double value1 = str.nextDouble();
                                    System.out.println("Insert maximum price\n");
                                    double value2 = str.nextDouble();
                                    System.out.println("filtered information successfully added to fileFilteredByPrice.txt \n");
                                    results.writeResults("FilteredByPrice.txt",necklaceActions.findStoneByPriceDiapazone(value1, value2, necklace.getList()).toString());
                                    System.out.println("\n Necklace Weight = " + String.format("%.2f",necklaceActions.calculateStoneWeight(necklaceActions.findStoneByPriceDiapazone(value1, value2,necklace.getList()))));
                                    System.out.println("\n Necklace Price = " + String.format("%.2f",necklaceActions.calculateStonesPrice(necklaceActions.findStoneByPriceDiapazone(value1, value2,necklace.getList()))));

                                } catch (InputMismatchException e) {
                                    throw new InputMismatchException("Inserted value do not correspond needed data type");
                                }
                            }continue;
                        case 5: {
                            System.out.println("Filter Stones by Clarity" + "\n Possible Clarity values are: \n" + Arrays.toString(ClarityType.values()));
                            System.out.println("Insert needed Clarity");
                            String value = str.next();
                            System.out.println("filtered information successfully added to file filteredNecklace.txt");
                            results.writeResults("filteredNecklace.txt", necklaceActions.filterByClarity(value, necklace.getList()).toString());
                            System.out.println("\n Necklace Weight = " + String.format("%.2f",necklaceActions.calculateStoneWeight(necklaceActions.filterByClarity(value,necklace.getList()))));
                            System.out.println("\n Necklace Price = " + String.format("%.2f",necklaceActions.calculateStonesPrice(necklaceActions.filterByClarity(value,necklace.getList()))));

                        }
                    }
                }
                catch (NumberFormatException e){
                    throw new NumberFormatException(e.getMessage());
                }
                catch (InputMismatchException ex){
                    throw new InputMismatchException(ex.getMessage());
                }
            }
        }
    }

        static void printMenu() {

        System.out.println("\n -----------------------------------------------------" +
                "\n|                        MENU                         |" +
                "\n -----------------------------------------------------\n" +
                "\n 1. Press 1 to Sort Stones by Price" +
                "\n 2. Press 2 to Sort stones by Gem Cut" +
                "\n 3. Press 3  to filter stones by Gem Cut" +
                "\n 4. Press 4  to filter stones by Price" +
                "\n 5. Press 5 to filter stones by Clarity"+
                "\n 5. Press Q to exit");
    }

}

