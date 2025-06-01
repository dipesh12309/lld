package com.lld.elevator;


import java.util.PriorityQueue;

public  class ElevatorController implements Runnable{

    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar){

        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b) -> b-a);

    }
     public void submitExternalRequest(int floor, Direction direction){

        if(direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
     }

    @Override
    public void run() {
        while(true){
            processRequests();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void processRequests() {
        ElevatorState state = elevatorCar.elevatorState;
        Direction currentDirection = elevatorCar.elevatorDirection;

        if(currentDirection == Direction.UP && !upMinPQ.isEmpty()){
            int destinationFloor = upMinPQ.poll();
            moveToFloor(destinationFloor);
        } else if(currentDirection == Direction.DOWN && !downMaxPQ.isEmpty()){
            int destinationFloor = downMaxPQ.poll();
            moveToFloor(destinationFloor);
        } else if(!downMaxPQ.isEmpty()){
            elevatorCar.elevatorDirection = Direction.DOWN;
        } else if(!upMinPQ.isEmpty()){
            elevatorCar.elevatorDirection = Direction.UP;
        } else{
            elevatorCar.elevatorDirection = Direction.IDLE;
        }
    }

    public void submitInternalRequest(int floor){
        if(floor > elevatorCar.currentFloor){
            upMinPQ.offer(floor);
        } else {
            downMaxPQ.offer(floor);
        }
    }

    private void moveToFloor(int floor) {
        System.out.println("Elevator " + elevatorCar.id + " moving from " + elevatorCar.currentFloor + " to " + floor);
        elevatorCar.currentFloor = floor;
        System.out.println("Elevator " + elevatorCar.id + " reached " + floor);
    }
}
