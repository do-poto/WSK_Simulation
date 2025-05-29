class Main{
    class simulationProgram{
        //establish a flag 
        var flag : Int = 0
        
        fun startSimulationProgram(){


            //display interface until flag is changed
            while(flag == 0){
                //print out text interface to cli
                println("\n##################################################")
                println("# WSK Simulation Project                         #")
                println("#------------------------------------------------#")
                println("# Choose one of the options:                     #")
                println("# [1] Start process scheduel simulation          #")
                println("# [2] Start page algorithm simulation            #")
                println("# [3] Quit                                       #")
                println("##################################################")
                
                //exception handling
                try{
                    var case : Int = readln().toInt()
                    
                    //Establish which option chosen
                    when(case){
                        1 -> startProcessTesting()
                        2 -> startPageTesting()
                        3 -> quitInterface()
                        else -> println("Invalid input. Choose from options above.")
                    }
                } catch(e: Exception){
                    //throw exception to the user
                    println("Wrong input type. Integers only!")
                }


            }
        }

        //function that starts testing processes in a given way
        fun startProcessTesting(){
            println("\n##################################################")
            println("# Choose one of the test cases:                  #")
            println("# [1] Fully random                               #")
            println("# [2] Random execution time                      #")
            println("# [3] Random arrival time                        #")
            println("# [4] Fully random with heavy execution time     #")
            println("##################################################")           
            
            try{
                //gather inputs from the user
                var proceessTestingType : Int = readln().toInt()
                println("Input amount of processes:")
                var processAmount : Int = readln().toInt()

                //initalize process objects
                var processGenerator = ProcessTestGenerator.TestGenerator(proceessTestingType, processAmount)
                processGenerator.fillProcessArray()
                var processGeneratorArray = processGenerator.processArray

                //sort by arrival time
                var arrivalSorter = arrivalTimeSort.quickSort()
                var arraySize = processGeneratorArray.size - 1
                arrivalSorter.sort(processGeneratorArray, 0, arraySize)
                
                //make exact copy of array for round robin
                var firstExactArrayCopy = processGeneratorArray.copyOf()
                //start round robin type execution
                var newRoundRobin = RoundRobin.startExecution()
                newRoundRobin.executioner(firstExactArrayCopy)

                //make second exact copy for shortest job first
                var secondExactArrayCopy = processGeneratorArray.copyOf()
                //start shortest job first type execution
                var newSJF = SJF.startExecution()
                newSJF.executioner(secondExactArrayCopy)

                //print results
                println("\n#################################################")
                println("Functions telemetry                              ")
                println("-------------------------------------------------")
                println("Round robin                                      ")
                println("Total time quants given: " + newRoundRobin.turnCounter)
                println("Total time quants given: " + newRoundRobin.timeQuantsWasted)
                println("Total round done: " + newRoundRobin.roundCounter)
                println("-------------------------------------------------")
                println("Shortest Job First")
                println("Total time quants given:" + newSJF.turnCounter)
                println("Longest wait time:" + newSJF.longestWaitTime)
                println("-------------------------------------------------")
                println("General")
                println("Total time quants requred:" + processGenerator.telemetryTotalProcessExecutionTime)
                println("#################################################")
                
                //finish program
                flag = 1
                
            } catch(e: Exception){
                println("Invalid input. Provide integers!")
            }
        }

        //function that starts page testing with given data
        fun startPageTesting(){
            try{

            } catch(e: Exception){
                println("Invalid input. Provide integers!")
            }

            flag = 1
        }


        fun quitInterface(){
            flag = 1
        }

    }
}

//the main of mains
fun main(){
    var simulationProgramInstance = Main.simulationProgram()
    simulationProgramInstance.startSimulationProgram()
}