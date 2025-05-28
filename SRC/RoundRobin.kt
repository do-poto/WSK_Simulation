import java.util.*

class RoundRobin{
  //starts the process of executing the processes
  class startExecution{
    //establish a time quant for each round
    val timeQuant : Int = 3

    //counter for the amount of rounds needed until process completion
    var turnCounter : Int = 0
    
    /*flag for the RoundRobin, on defualt 0
    if the flag is 0 it will continue the process of distribution
    if the flag is 1 then all of the processes have been completed */
    var flag = 0

    var processQueue : Queue<ProcessTestGenerator.ProcessObject?> = LinkedList()

    //executes the processes 
    fun executioner(processArray : Array<ProcessTestGenerator.ProcessObject?>){
        while(flag == 0){
            queueCreator(processArray, turnCounter)
            while(processQueue.isEmpty() == false){
                processQueue.peek()!!.executionTime = processQueue.peek()!!.executionTime - timeQuant
                processQueue.poll()
            }
            turnCounter = turnCounter + timeQuant
        }
    }
    
    //creates a process queue for the executioner
    fun queueCreator(processArray : Array<ProcessTestGenerator.ProcessObject?>, turnCounter : Int){
        //fill queue
        for (item in processArray){
            if(item!!.arrivalTime <= turnCounter){
                if(item!!.executionTime > 0){
                    processQueue.add(item)
                }
            }
        } 
        /*after the completion of the filling
        if the queue is empty the flag will be changed to 1*/
        if(processQueue.isEmpty()){
            flag = 1
        }
    }
  }
}



fun main(){
    var generator = ProcessTestGenerator.TestGenerator(100, 1)
    generator.fillProcessArray()
    var array = generator.processArray
    println("Before sort")
    for(items in array){
        println("Arrival: " + items?.arrivalTime + " Exec: " + items?.executionTime)
    }

    var sort = ArrivalTimeSort.quickSort()
    var size = array.size -1
    sort.sort(array, 0, size)
    println("After sort")
    for(items in array){
        println("Arrival: " + items?.arrivalTime + " Exec: " + items?.executionTime)
    }
    
    var robin = RoundRobin.startExecution()
    robin.executioner(array)

    println("After execution")
    for(items in array){
        println("Arrival: " + items?.arrivalTime + " Exec: " + items?.executionTime)
    }
    println("Turns done: " + robin.turnCounter)

}