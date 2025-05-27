open class QuickSort{
    //begining of the algorithm
    fun sort(arr : IntArray, low : Int, high : Int){
        if(low < high){
            var pivot = partition(arr, low, high)
            var subhigh = pivot-1 
            var sublow = pivot+1
            sort(arr, low, subhigh)
            sort(arr, sublow, high)
        }
    }

    //partition function of the quicksort
    fun partition(arr : IntArray, low : Int, high : Int) : Int{
        var pivot = arr[high]

        var i = low-1

        var j = low
        while(j <= high-1){
            if(arr[j] < pivot){
                i++
                swap(arr, i, j)
            }
            j++
        }

        var returned = i+1
        swap(arr, returned, high)
    
        return returned
    }

    fun swap(arr : IntArray, i : Int, j : Int){
        var temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

}

fun main(){
    var array = intArrayOf(9, 9, 0, -3, 10, 1, 11)
    var mysort = QuickSort()
    var size = array.size-1
    mysort.sort(array, 0, size)


}