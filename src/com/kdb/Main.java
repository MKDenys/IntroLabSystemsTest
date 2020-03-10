package com.kdb;

public class Main {

    public static final int CURRENT_LEVEL = 0;

    public static void main(String[] args) {
        Building building = new Building();
        int levelPassengersCounter = building.getLevel(CURRENT_LEVEL).getPassengers().size();
        for (int i = 0; i < building.getLevel(CURRENT_LEVEL).getPassengers().size() && building.getElevator().getVacancies() > 0;){
            building.getLevel(CURRENT_LEVEL).getPassengers().get(i).enterToElevator(building.getElevator(), building.getLevel(CURRENT_LEVEL));
            if (levelPassengersCounter == building.getLevel(CURRENT_LEVEL).getPassengers().size()){
                i++;
            } else {
                levelPassengersCounter = building.getLevel(CURRENT_LEVEL).getPassengers().size();
            }
        }
        showBuildingState(building);
        int i = CURRENT_LEVEL;
        while (true){
            if (building.getElevator().getDirection() == Direction.UP){
                i++;
            } else {
                i--;
            }
            building.getElevator().moveTo(building.getLevel(i));
            showBuildingState(building);
        }
    }

    private static void showBuildingState(Building building){
        System.out.println(String.format("Elevator on %d level", building.getElevator().getCurrentLevelNumber()));
        System.out.println(String.format("Passengers in elevator %d", building.getElevator().getPassengersCount()));
        for (int i = 0; i < building.getElevator().getPassengersCount(); i++){
            System.out.print(String.format("%s, ", building.getElevator().getPassengers().get(i).getName()));
        }
        System.out.println();
        for (int i = 0; i < building.getLevelsCount(); i++){
            System.out.println(String.format("Level %d ", i + 1));
            System.out.println(String.format("Passengers %d: ", building.getLevel(i).getPassengers().size()));
            for (int j = 0; j < building.getLevel(i).getPassengers().size(); j++){
                System.out.print(String.format("%s, ", building.getLevel(i).getPassengers().get(j).getName()));
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println();
    }


}
