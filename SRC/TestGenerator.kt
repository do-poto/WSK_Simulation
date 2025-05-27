
//class of ProcessObject that will be added to the TestGenerator
class ProcessObject(var arrivalTime: Int, var executionTime : Int){
    //Function for decrementing the value of the object
    /*fun decrement(var timeQuantProvided : Int){
        var executionTime = executionTime - timeQuantProvided
        if(executionTime <= 0){
            this.finalize()
        }
    }
    */
}

/*initialize class of TestGenerator that will provide
the simulations with certain amount of objects 
of certain arrival time, execution time*/
class TestGenerator(var processAmount: Int){
    //initializes array for ProcessObjects
    var processArray = Array<ProcessObject?>(processAmount) {null}
    
    //casting a total amount of time spent 
    var totalExecutionTime : Int = 0
    
    fun fillProcessArray(){
        var i : Int = 0
        while(i < processAmount){
            var randomA = (1..10).shuffled().first()
            var randomB = (1..10).shuffled().first()
            processArray[i] = ProcessObject(randomA, randomB)
            i++
        }
    }
}


fun main(){
    val generated = TestGenerator(5)
    generated.fillProcessArray()
    println(generated.processArray[0]?.executionTime)


}
