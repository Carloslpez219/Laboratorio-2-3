data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)

fun main() {
    val result = processList(listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var lista: ArrayList<ItemData>? = ArrayList<ItemData>()
    var position = 0
    var nulos = 0
    
    if(inputList == null){
        return null;
    }
    
    for(item in inputList.orEmpty()){
       if(item == null){
           nulos ++
       }
    }
    
    if(nulos != inputList.size){
        for (item in inputList.orEmpty()){
        
       		if (item != null) {
           		var objeto: ItemData = ItemData(0, "", "", "")
           		objeto.originalPos = position
       
           		when (item) {
                	is String -> objeto.type = "cadena"
                	is Int -> objeto.type = "entero"
                	is Boolean -> objeto.type = "booleano"
                	else -> objeto.type = null
            	}
        
            	objeto.originalValue = item

           		when (item) {
                	is String -> objeto.info = "L" + item.length
                	is Int -> {  if(item%10 == 0) objeto.info = "M10" else if(item%5 == 0) objeto.info = "M5" else if(item%2 == 0) objeto.info = "M2" else objeto.info = null}
                	is Boolean -> { if(item == true) objeto.info = "Verdadero" else objeto.info = "Falso"}
                	else -> objeto.info = null
            	}
            	lista?.add(objeto)
       		}
        	position ++
      	}    
    }
    
    return lista
}