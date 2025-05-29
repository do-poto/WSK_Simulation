import java.util.*

class MFU{
    class Frame{
        //creates frame for the algorithm
        fun managePages(frameSize : Int, pagesArray : IntArray){
            //page miss count
            var pageMissCount = 0
            //page hit count
            var pageHitCount = 0
            //intialize array of int of certain size
            var frameArray = IntArray(frameSize)

            //start process
            for(pageOS in pagesArray){
                var target = pageOS
                //check if page exists in frame
                if(target in frameArray){
                    //page found
                    pageHitCount++
                } else if(0 in frameArray){
                    //page not found and there is space in frame
                    pageMissCount++
                    var i : Int = 0
                    //replace the empty space
                    while(i < frameSize){
                        if(frameArray[i] == 0){
                            frameArray[i] = target
                            break
                        }
                        i++
                    }
                } else {
                    //page not found and no more space in frame available
                    pageMissCount++
                    //initialize highest usage 
                    var highestUsage : Int = -1
                    var highestUsageLocation : Int = -1
                    //find highest usage location
                    var j : Int = 0
                    //start MFU process
                    while(j < frameSize){
                        if(frameArray[j] > highestUsage){
                            highestUsage = frameArray[j]
                            highestUsageLocation = j
                        }
                        j++
                    }
                    frameArray[highestUsageLocation] = target
                }
            }
        }
    }
}


fun main(){
    var newGenerator = PagesGenerator.generator()
    var arr = newGenerator.createPages(10)

    var MFUAl = MFU.Frame()
    MFUAl.managePages(4, arr)

}