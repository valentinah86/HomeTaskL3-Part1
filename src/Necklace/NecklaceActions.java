package Necklace;




import CustomErrors.ElementNotFound;
import CustomErrors.IncorrectCountOfStones;
import CustomErrors.InvalidStonePrice;
import Stones.Stone;
import Stones.StoneGenerator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NecklaceActions {


    public Necklace createNecklace (Necklace necklace, int countOfStones) throws ElementNotFound, IncorrectCountOfStones {

        if (countOfStones >0){

            StoneGenerator newStone = new StoneGenerator();
            ArrayList <Stone> stonesList = new ArrayList<>();

            for (int i=0; i<countOfStones; i++){
                stonesList.add(newStone.createStone());
            }
            necklace.setStonesList(stonesList);
        }
        else { throw new IncorrectCountOfStones("Count of stones cannot be less than 1");

        }


        return necklace;
    }

    public double calculateStoneWeight (ArrayList<Stone> stonesList){

        double necklaceWeight = 0.0;

        for (Stone stone: stonesList){
            necklaceWeight += stone.getWeight();
        }
        return necklaceWeight;
    }

    public double calculateStonesPrice (ArrayList<Stone> stonesList){
        double necklacePrice = 0.0;

        for (Stone stone: stonesList){
            necklacePrice += stone.getPrice();
        }
        return necklacePrice;
    }

    public ArrayList sortStonesByPrice (ArrayList<Stone> stones){
        Collections.sort(stones, new Comparator<Stone>() {
            @Override
            public int compare(Stone o1, Stone o2) {
                return Double.compare(o1.getPrice(),o2.getPrice());
            }
        });
        return stones;
    }

    public ArrayList sortStonesByGemCutting(ArrayList<Stone> stones){
        Collections.sort(stones, new Comparator<Stone>() {
            @Override
            public int compare(Stone o1, Stone o2) {
                return Character.compare(o1.getGemCuttingType().toString().charAt(0),o2.getGemCuttingType().toString().charAt(0));
            }
        });
        return stones;
    }


    public ArrayList<Stone> findStoneByGemCut(String gemCuttingType, ArrayList<Stone> stonesList) throws ElementNotFound {

        ArrayList<Stone> filteredStoneList = new ArrayList<>();
        for (Stone stone : stonesList) {

            if (stone.getGemCuttingType().toString().equals(gemCuttingType)) {
                filteredStoneList.add(stone);
            }

        }
        if (filteredStoneList.size() == 0) {
            throw new ElementNotFound("Requested Gem Cut is absent in collection");
        }
        return filteredStoneList;
    }

    public ArrayList<Stone> findStoneByPriceDiapazone (double priceA, double priceB, ArrayList<Stone> stonesList) throws InvalidStonePrice {

        ArrayList<Stone> filteredStoneList = new ArrayList<>();
        if (priceA > 0 && priceB > 0) {
            for (Stone stone : stonesList) {

                if (priceA <= stone.getPrice() && priceB >= stone.getPrice()) {
                    filteredStoneList.add(stone);
                }
            }

        } else {
            try {
                throw new InvalidStonePrice("Stone price cannot be null or negative");
            } catch (InvalidStonePrice invalidStonePrice) {
                invalidStonePrice.printStackTrace();
            }
        }
        return filteredStoneList;
    }

    public ArrayList<Stone> filterByClarity (String clarity, ArrayList<Stone> stonesList) throws ElementNotFound {
        ArrayList<Stone> filteredList = new ArrayList<>();

        for (Stone stone: stonesList){

            if (stone.getClarityType().toString().equals(clarity)){
                filteredList.add(stone);
            }

        }
        if (filteredList.size()==0){
            throw new ElementNotFound("Requested Gem Cut is absent in current collection");
        }

         return filteredList;
    }

}
