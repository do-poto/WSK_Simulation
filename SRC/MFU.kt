import java.util.*

class MFU{
    class Frame{
        //creates frame for the algorithm
        fun managePages(frameSize : Int, pagesArray : IntArray){
            //intialize array of int of certain size
            var frameArray = IntArray(frameSize)

            //calculates the actual array size
            var actualFrameArraySize : Int = frameSize - 1
            var actualPageArraySize : Int = pagesArray.size - 1
            //fill empty array
            var i : Int= 0
            while(i < actualFrameArraySize){
                frameArray[i] = pagesArray[i]
                i++
            }
            println(frameArray.joinToString())

            //start MFU process
            i++
            while(i < actualPageArraySize){
                //initialize highest usage 
                var highestUsage : Int = -1
                var highestUsageLocation : Int = -1
                //find highest usage location
                var j : Int = 0
                while(j < actualFrameArraySize){
                    if(frameArray[j] > highestUsage){
                        highestUsage = frameArray[j]
                        highestUsageLocation = j
                    }
                    j++
                }
                frameArray[highestUsageLocation] = pagesArray[i]
                println(frameArray.joinToString())
                i++
            }


        }
    }
}


fun main(){
    var newGenerator = PagesGenerator.generator()
    var arr = newGenerator.createPages(10)

    var MFUAl = MFU.Frame()
    MFUAl.managePages(3, arr)

}