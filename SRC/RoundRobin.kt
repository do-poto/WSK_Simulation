class RoundRobin(){
  //starts the process of executing the processes
  class startExecution(){
    //establish a time quant for each round
    val timeQuant : Int = 3

    //counter for the amount of rounds needed until process completion
    var turnCounter : Int = 0

    //executes the processes 
    fun executioner(var timeQuant : Int, var turnCounter : Int){




    }
    
    //creates a process queue for the executioner
    fun queueCreator(var processArray : Array<ProcessTestGenerator.ProcessObject?>, var turnCounter : Int){
        var processQueue
        
        
        for (item in processArray){
            if(item?.arrivalTime <= turnCounter){

            }
        } 



        return 
    }
  }
}



fun main(){




}