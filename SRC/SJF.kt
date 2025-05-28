/*Variables and function definitions that are similar or present to the 
RoundRobin algoritm such as flag or turn counter may have less explenation 
in their coment as this feature has been developed after the RoundRobin algorithm.
Some coments however will still be present to maintain code readability*/

class SJF{
    class startExecution{
        var turnCounter = 0
        
        var flag = 0
        
        fun executioner(processArray : Array<ProcessTestGenerator.ProcessObject?>){





        }

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

    var sort = ExecutionTimeSort.quickSort()
    var size = array.size -1
    sort.sort(array, 0, size)
    println("After sort")
    for(items in array){
        println("Arrival: " + items?.arrivalTime + " Exec: " + items?.executionTime)
    }
    
    var shortest = SJF.startExecution()
    shortest.executioner(array)

    println("After execution")
    for(items in array){
        println("Arrival: " + items?.arrivalTime + " Exec: " + items?.executionTime)
    }
    println("Turns done: " + robin.turnCounter)

}