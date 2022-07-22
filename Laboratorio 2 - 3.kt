// Universidad del valle de Guatemala
// Programación de plataformas móviles
// Sección: 20
// Carlos Edgardo López Barrera
// 21666
// Creado: 15/07/2022
// Modificado: 22/07/2022

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
	if(inputList!=null){
		inputList.forEachIndexed {index, ele ->
			if(ele!=null){
				var itemData:ItemData = when(ele){
					is String -> ItemData(index, ele, "cadena", "L${ele.length}")
					is Int -> ItemData(index, ele, "entero", if(ele%10==0) "M10" else if(ele%5==0) "M5" else if(ele%2==0) "M2" else null)
					is Boolean -> ItemData(index, ele, "booleano", if(ele) "Verdadero" else "Falso")
					else -> ItemData(index, ele, null, null)
				}
				lista?.add(itemData)
			}
		}
		return lista
	}else{
		return null
	}
}