class PagesGenerator{
    class generator{
        //generates a given amount of pages
        fun createPages(pagesAmount : Int) : IntArray {
            //creates an empty array
            var pagesArray = IntArray(pagesAmount)
            
            //var for iteration
            var i = 0
            //fills array with pages
            while(i < pagesAmount){
                //generates random page usage
                var pageUsage : Int = (1..10).shuffled().first()
                //array filled at place
                pagesArray[i] = pageUsage

                i++
            }
            //returns a ready array
            return pagesArray
        }
    }
}