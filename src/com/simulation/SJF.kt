import java.util.*

class SJF{
    class startExecution{
        //time quant to subtract from execution time
        var timeQuant = 1
        //counts the current time quant
        var turnCounter = 0       
        //flag for stopping the funcition
        var flag = 0
        //initlaize longest wait time var
        var longestWaitTime = 0
        //creation of empty queue with global access
        var processQueue : Queue<ProcessTestGenerator.ProcessObject?> = LinkedList()

        //execution of the shortest processs
        fun executioner(processArray : Array<ProcessTestGenerator.ProcessObject?>){
            //calculate longest wait time
            var lastEntryPlace : Int = processArray.size - 1
            var i = 0
            while(i < lastEntryPlace){
                //add all processes that will be before it 
                longestWaitTime = longestWaitTime + processArray[i]!!.executionTime
                i++
            }
            //subtract its arrival time
            longestWaitTime = longestWaitTime - processArray[lastEntryPlace]!!.arrivalTime

            //starts repeating the execution until the flag is changed
            while(flag == 0){
                //call for queue creator
                queueCreator(processArray, turnCounter)
                //starts the substraction until process is finished
                if(processQueue.isEmpty() == false){
                    while(processQueue.peek()!!.executionTime > 0){
                        processQueue.peek()!!.executionTime = processQueue.peek()!!.executionTime - timeQuant
                        //tracks current time
                        turnCounter = turnCounter + timeQuant
                    }
                    //empties the queue for the next process
                    processQueue.poll()
                }
            }
        }

        fun queueCreator(processArray : Array<ProcessTestGenerator.ProcessObject?>, turnCounter : Int){
            //variable with arbitrary high number for the shortest job execution time finding
            var shortestExecution : Int = Int.MAX_VALUE
            //holder for the process that will be executed
            var toBeExecuted : ProcessTestGenerator.ProcessObject? = null
            
            //fill queue
            for (item in processArray){
                if(item!!.arrivalTime <= turnCounter){
                    if(item!!.executionTime > 0 && item!!.executionTime < shortestExecution){
                        //new shortest execution time
                        shortestExecution = item!!.executionTime
                        //new item to be added to the queue
                        toBeExecuted = item!!
                    }
                } else {
                    break
                }
            } 
            //appends the process to the queue
            if(toBeExecuted != null){
                processQueue.add(toBeExecuted)
            }

            if(processQueue.isEmpty()){
                flag = 1
            }
        }
    }
}
