class ProcessTestGenerator{
    //class of ProcessObject that will be added to the TestGenerator
    class ProcessObject(var arrivalTime: Int, var executionTime : Int){
        //Function for decrementing the value of the object
        fun decrement(timeQuantProvided : Int){
            var executionTime = executionTime - timeQuantProvided
        }
    }
    
    /*initialize class of TestGenerator that will provide
    the simulations with certain amount of objects 
    of certain arrival time, execution time*/
    class TestGenerator(var processAmount: Int, var case : Int){
    //initializes array for ProcessObjects
    var processArray = Array<ProcessObject?>(processAmount) {null}
    //counts the total time of execution of exery process
    var telemetryTotalProcessExecutionTime : Int = 0

    //function to fill the processArray with ProcessObjects
    fun fillProcessArray(){
        when(case){
            1 -> fullRandom()
            2 -> randomExecution()
            3 -> randomArrival()
        }
    }

    //fully random ProcessObject time of arrival and execution
    fun fullRandom(){
        var i : Int = 0
        //iterates through the whole array of objects
        while(i < processAmount){
            //randomize ProcessObject.arrivalTime
            var randomA = (0..10).shuffled().first()
            //randomize ProcessObject.executionTime
            var randomB = (1..10).shuffled().first()
            telemetryTotalProcessExecutionTime = telemetryTotalProcessExecutionTime + randomB
            //creates an object with set variables
            processArray[i] = ProcessObject(randomA, randomB)
            i++
        }
    }

    //function for random arrival time 
    fun randomArrival(){
        var i : Int = 0
        //iterates through the whole array of objects
        while(i < processAmount){
            //randomize ProcessObject.arrivalTime
            var randomA = (0..10).shuffled().first()
            //the same execution time for all ProcessObjects
            var fixed : Int = 5
            telemetryTotalProcessExecutionTime = telemetryTotalProcessExecutionTime + fixed
            //creates an object with set variables
            processArray[i] = ProcessObject(randomA, fixed)
            i++
        }
    }

    //function for random execution time
    fun randomExecution(){
        var i : Int = 0
        //iterates through the whole array of objects
        while(i < processAmount){
            //the same arrival time for all ProcessObjects
            var fixed = 0
            //randomize ProcessObject.executionTime
            var randomB = (1..10).shuffled().first()
            telemetryTotalProcessExecutionTime = telemetryTotalProcessExecutionTime + randomB
            //creates an object with set variables
            processArray[i] = ProcessObject(fixed, randomB)
            i++
        }
    }
}

}