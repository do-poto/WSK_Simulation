import java.util.*

class FIFO{
    class Frame{
        //Creates a frame for the FIFO algorithm
        fun managePages(frameSize : Int, pagesArray : IntArray){
            //frame initialized
            var frameQueue : Queue<Int> = LinkedList()
            
            //creates actual queue size
            var actualQueueSize : Int = frameQueue.size - 1
            
            //iterates through all of the proceess in the pagesArray
            for(page in pagesArray){
                //check if he size is greater than expected
                if(actualQueueSize >= frameSize){
                    //remove first item
                    frameQueue.poll()
                    //add new item
                    frameQueue.add(page)
                } else {
                    //otherwise add another page
                    frameQueue.add(page)
                }
                if(frameQueue.isEmpty() == false){
                    var outline = ""
                    for(item in frameQueue){
                        outline = outline + item + ", "  
                    }
                    println(outline)
                }
            }
        }
    }
}


fun main(){
    var newGenerator = PagesGenerator.generator()
    var arr = newGenerator.createPages(10)

    var FIFOAl = FIFO.Frame()
    FIFOAl.managePages(3, arr)

}