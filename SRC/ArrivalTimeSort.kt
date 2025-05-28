class ArrivalTimeSort{
    //quicksort implementation for arrival time of a process
    class quickSort{
        //begining of the algorithm
        fun sort(arr : Array<ProcessTestGenerator.ProcessObject?>, low : Int, high : Int){
            if(low < high){
                var pivot = partition(arr, low, high)
                var subhigh = pivot-1 
                var sublow = pivot+1
                sort(arr, low, subhigh)
                sort(arr, sublow, high)
            }
        }

        //partition function of the quicksort
        fun partition(arr : Array<ProcessTestGenerator.ProcessObject?>, low : Int, high : Int) : Int{
            //reference ProcessTestGenerator.ProcessObject.arrivalTime as nullable Int 
            var pivot : Int? = arr[high]?.arrivalTime
            //entrust the var that it is not null
            var pivotTrusted : Int = pivot!! 

            //initialize indexes
            var i = low-1
            var j = low
            
            while(j <= high-1){
                //reference ProcessTestGenerator.ProcessObject.arrivalTime as nullable Int 
                var compare : Int? = arr[j]?.arrivalTime
                //entrust the var that it is not null
                var compareTrusted : Int = compare!!
                //compare entries
                if(compareTrusted < pivotTrusted){
                    i++
                    //invoke swap of two processes
                    swap(arr, i, j)
                }
                j++
            }

            //create a temporary var that will be passed
            var returned = i+1
            
            swap(arr, returned, high)
            
            return returned
        }

        //function that swaps index if one has greater value than another
        fun swap(arr : Array<ProcessTestGenerator.ProcessObject?>, i : Int, j : Int){
            var temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }

    }

}