package com.lld.elevator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        List<Floor> floorList = new ArrayList<>();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);

        Building building = new Building(floorList);

        floor1.externalDispatcher.submitExternalRequest(8,Direction.UP);
        floor2.externalDispatcher.submitExternalRequest(1,Direction.UP);
        floor3.externalDispatcher.submitExternalRequest(3,Direction.UP);
        floor4.externalDispatcher.submitExternalRequest(2,Direction.DOWN);
        floor5.externalDispatcher.submitExternalRequest(8,Direction.DOWN);
        floor1.externalDispatcher.submitExternalRequest(2,Direction.UP);

        floor1.externalDispatcher.submitExternalRequest(8,Direction.UP);
        floor2.externalDispatcher.submitExternalRequest(1,Direction.UP);
        floor3.externalDispatcher.submitExternalRequest(3,Direction.UP);
        floor4.externalDispatcher.submitExternalRequest(2,Direction.DOWN);
        floor5.externalDispatcher.submitExternalRequest(8,Direction.DOWN);
        floor1.externalDispatcher.submitExternalRequest(2,Direction.UP);

        for (ElevatorController elevatorController : ElevatorCreator.elevatorControllerList) {
            elevatorController.submitInternalRequest(4);
            elevatorController.submitInternalRequest(3);
            elevatorController.submitInternalRequest(1);
            elevatorController.submitInternalRequest(5);
            elevatorController.submitInternalRequest(9);
            elevatorController.submitInternalRequest(10);
        }
    }
}
