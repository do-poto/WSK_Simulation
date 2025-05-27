
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
    
    //function to fill the processArray with ProcessObjects
    fun fillProcessArray(){
        when(case){
            1 -> fullRandom()
            2 -> radnomExecution()
            3 -> randomArrival()
        }
    }

    //fully random ProcessObject time of arrival and execution
    fun fullRandom(){
        var i : Int = 0
        while(i < processAmount){
            //randomize ProcessObject.arrivalTime
            var randomA = (1..10).shuffled().first()
            //randomize ProcessObject.executionTime
            var randomB = (1..10).shuffled().first()
            //creates an object with set variables
            processArray[i] = ProcessObject(randomA, randomB)
            i++
        }
    }

    //function for random arrival time 
    fun randomArrival(){
                var i : Int = 0
        while(i < processAmount){
            //randomize ProcessObject.arrivalTime
            var randomA = (1..10).shuffled().first()
            //the same execution time for all ProcessObjects
            var fixed : Int = 5
            //creates an object with set variables
            processArray[i] = ProcessObject(randomA, fixed)
            i++
        }
    }

    //function for random execution time
    fun radnomExecution(){
        var i : Int = 0
        while(i < processAmount){
            //the same arrival time for all ProcessObjects
            var fixed = 2
            //randomize ProcessObject.executionTime
            var randomB = (1..10).shuffled().first()
            //creates an object with set variables
            processArray[i] = ProcessObject(randomA, randomB)
            i++
        }
    }

}


fun main(){
    val generated = TestGenerator(5, 1)
    generated.fillProcessArray()
    println(generated.processArray[0]?.executionTime)


}
