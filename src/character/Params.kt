package character

open class CharacterParams {
    var hungry : Int = 50 // голод, восполняется едой
    var loneliness : Int = 50 // одиночество, восп общением
    var tiredness : Int = 50 // усталость - отдыхом
    var ambiguity : Int = 50 // неясность, неведение - просмотром и чтением новостей, общением

    fun addHungry(value: Int){
        hungry += value
        checkParams("hungry")
    }
    fun reduceHungry(value: Int){
        hungry -= value
        checkParams("hungry")
    }
    fun addLoneliness(value: Int){
        loneliness += value
        checkParams("loneliness")
    }
    fun reduceLoneliness(value: Int){
        loneliness -= value
        checkParams("loneliness")
    }
    fun addTiredness(value: Int){
        tiredness += value
        checkParams("tiredness")
    }
    fun reduceTiredness(value: Int){
        tiredness -= value
        checkParams("tiredness")
    }
    fun addAmbiguity(value: Int){
        ambiguity += value
        checkParams("ambiguity")
    }
    fun reduceAmbiguity(value: Int){
        ambiguity -= value
        checkParams("ambiguity")
    }

    private fun checkParams(type : String){
        when(type) {
            "hungry" ->
                if (hungry < 0) hungry = 0
                else if (hungry >= 100) {
                    hungry = 100
                }
            "loneliness" ->
                if (loneliness < 0) loneliness = 0
                else if (loneliness >= 100) {
                    loneliness = 100
                }
            "tiredness" ->
                if (tiredness < 0) tiredness = 0
                else if (tiredness >= 100) {
                    tiredness = 100
                }
            "ambiguity" ->
                if (ambiguity < 0) ambiguity = 0
                else if (ambiguity >= 100) {
                    ambiguity = 100
                }
        }
    }

}