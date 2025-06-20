import java.util.*

class FIFO{
    class Frame{
        //page miss count
        var pageMissCount = 0
        //page hit count
        var pageHitCount = 0
        //Creates a frame for the FIFO algorithm
        fun managePages(frameSize : Int, pagesArray : IntArray){
            //frame initialized
            var frameQueue : Queue<Int> = LinkedList()
            //creates actual queue size
            var currentQueueSize : Int = 0
            //iterates through all of the proceess in the pagesArray
            for(page in pagesArray){
                //check if he size is greater than expected
                if(frameQueue.contains(page)){
                    //count hit
                    pageHitCount++
                } else if(currentQueueSize >= frameSize){
                    //count miss
                    pageMissCount++
                    //remove first item
                    frameQueue.poll()
                    //add new item
                    frameQueue.add(page)
                } else {
                    //count miss
                    pageMissCount++
                    //otherwise add another page
                    frameQueue.add(page)
                    //track queue size
                    currentQueueSize++
                }
            }
        }
    }
}